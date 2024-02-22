package ec.edu.utpl.complexivo.socket;


import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.oauth2.jose.jws.JwsAlgorithms;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /*private final Map<String, WebSocketSession> sessions = new HashMap<>();

    @Autowired
    private TradeWebSocketHandler tradeWebSocketHandler;

    @Bean("sessions")
    public Map<String, WebSocketSession> getSessions() {
        return sessions;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(tradeWebSocketHandler, "/solicitudes").setAllowedOrigins("*");
    }*/

    private final Map<String, WebSocketSession> sessions = new HashMap<>();

    @Bean("sessions")
    public Map<String, WebSocketSession> getSessions() {
        return sessions;
    }

    @Bean
    public HandshakeInterceptor auctionInterceptor() {
        return new HandshakeInterceptor() {
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                           WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

                // Get the URI segment corresponding to the auction id during handshake
                //String path = request.getURI().getPath();
                //String auctionId = path.substring(path.lastIndexOf('/') + 1);

                // This will be added to the websocket session
                //attributes.put("auctionId", auctionId);
                String token[] = request.getURI().getQuery().split("=");
                if (token.length != 0) {
                    BearerTokenAuthenticationToken authenticationRequest = new BearerTokenAuthenticationToken(token[1]);

                }
                return true;
            }

            public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                       WebSocketHandler wsHandler, Exception exception) {
                // Nothing to do after handshake
            }
        };
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        log.info("registry {}", registry);
        registry.addHandler(new CustomWebSocketHandler(sessions), "/ws/notifications/")
                .setAllowedOrigins("*").setHandshakeHandler(new DefaultHandshakeHandler() {
                    @Override
                    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                        Principal principal = null;
                        String token[] = request.getURI().getQuery().split("=");
                        if (token.length != 0) {
                            /*BearerTokenAuthenticationToken tokenAuthenticationToken = new BearerTokenAuthenticationToken(token[1]);
                            JWKSource<SecurityContext> keySource = null;
                            try {
                                keySource = new RemoteJWKSet<>(new URL("http://localhost:8080/realms/policianacional/protocol/openid-connect/certs"));
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                            JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
                            JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(expectedJWSAlg, keySource);
                            ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
                            jwtProcessor.setJWSKeySelector(keySelector);
                            JwtDecoder jwtDecoder = new NimbusJwtDecoder(jwtProcessor);

                            Jwt jwt = jwtDecoder.decode(token[1]);
                            principal = (Principal) jwt.getClaims();*/

                            JwtDecoder jwtDecoder = NimbusJwtDecoder
                                    .withJwkSetUri("http://localhost:8080/realms/policianacional/protocol/openid-connect/certs")
                                    .build();
                            Jwt jwt = jwtDecoder.decode(token[1]);

                            //Jwt jwt = Jwt.withTokenValue(token[1]).build();
                            //JwtAuthenticationToken authRequest = new JwtAuthenticationToken(to);
                            //SignatureAlgorithm sa = SignatureAlgorithm.RS256;
                            //SecretKeySpec secretKeySpec = new SecretKeySpec("gestion-vehicular-api".getBytes(), sa.getJcaName());
                            //JwtParser jwtParser = Jwts.parser()
                                    //.verifyWith(secretKeySpec)
                                    //.build();
                            //io.jsonwebtoken.Jwt jwt = jwtParser.parse(token[1]);
                        }
                        return principal;
                    }
                });
    }


}
