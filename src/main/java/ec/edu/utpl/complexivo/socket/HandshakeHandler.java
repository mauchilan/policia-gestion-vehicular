package ec.edu.utpl.complexivo.socket;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class HandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler handler, Map<String, Object> attributes) {

        HttpHeaders headers = request.getHeaders();
        System.out.println(headers);
        return null;
    }
}
