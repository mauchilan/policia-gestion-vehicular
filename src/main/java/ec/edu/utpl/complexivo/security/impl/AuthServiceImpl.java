package ec.edu.utpl.complexivo.security.impl;

import ec.edu.utpl.complexivo.security.AuthService;
import jakarta.annotation.PostConstruct;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.authorization.client.representation.TokenIntrospectionResponse;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.keycloak.representations.idm.authorization.Permission;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Value( "${auth.complexivo.keycloak.realm}" )
    private String realm;
    @Value( "${auth.complexivo.keycloak.server}" )
    private String server;
    @Value( "${auth.complexivo.keycloak.resource}" )
    private String resource;
    @Value( "${auth.complexivo.keycloak.secret}" )
    private String secret;
    private AuthzClient authzClient;

    @PostConstruct
    public void init() {
        Configuration configuration = new Configuration();
        configuration.setRealm(realm);
        configuration.setAuthServerUrl(server);
        configuration.setResource(resource);
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("secret", secret);
        configuration.setCredentials(credentials);
        authzClient = AuthzClient.create(configuration);
    }

    @Override
    public List<ResourceRepresentation> getAuth(String token) {
        String[] bearer = token.split(" ");
        List<ResourceRepresentation> representations = new ArrayList<>();
        AuthorizationResponse response = authzClient.authorization(bearer[1]).authorize();
        // introspect the token
        TokenIntrospectionResponse requestingPartyToken = authzClient.protection().introspectRequestingPartyToken(response.getToken());
        for (Permission granted : requestingPartyToken.getPermissions()) {
            ResourceRepresentation resourceRepresentation = authzClient.protection().resource().findByName(granted.getResourceName());
            representations.add(resourceRepresentation);
        }
        return representations;
    }
}
