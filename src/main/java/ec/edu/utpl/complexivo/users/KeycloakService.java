package ec.edu.utpl.complexivo.users;

import ec.edu.utpl.complexivo.dto.UserDto;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeycloakService {

    private final String REALM = "policianacional";

    @Autowired
    private Keycloak keycloak;

    public UserRepresentation searchById(String id) {
        UserResource userResource = keycloak.realm(REALM).users().get(id);
        return userResource.toRepresentation();
    }

    public List<UserRepresentation> allUser() {
        return keycloak.realm(REALM).users().list();
    }

    public List<UserRepresentation> findByAttributes(String attributte, String value) {
        StringBuilder search = new StringBuilder();
        search.append(attributte).append(":").append(value);
        return keycloak.realm(REALM).users().searchByAttributes(search.toString());
    }

    public void updateDependencia(UserDto users) {
        String dependencia = users.getDependencia().getIdDependencia().concat("|").concat(users.getDependencia().getNombreDependencia());
        users.getUsers().stream().forEach(user -> {
            List<String> values = new ArrayList<>();
            values.add(dependencia);
            user.getAttributes().put("dependencia", values);
            keycloak.realm(REALM).users().get(user.getId()).update(user);
        });
    }
}
