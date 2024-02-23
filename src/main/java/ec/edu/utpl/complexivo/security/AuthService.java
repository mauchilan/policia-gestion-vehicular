package ec.edu.utpl.complexivo.security;

import org.keycloak.representations.idm.authorization.ResourceRepresentation;

import java.util.List;

public interface AuthService {

    List<ResourceRepresentation> getAuth(String token);

}
