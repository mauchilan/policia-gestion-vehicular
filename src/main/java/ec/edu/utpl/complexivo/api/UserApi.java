package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.dto.UserDto;
import ec.edu.utpl.complexivo.users.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private KeycloakService keycloakService;

    @GetMapping("/id/{id}")
    public ResponseEntity<UserRepresentation> searchById(@PathVariable String id) {
        return ResponseEntity.ok().body(keycloakService.searchById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserRepresentation>> getAllUser() {
        return ResponseEntity.ok(keycloakService.allUser());
    }

    @GetMapping("/users/{attribute}/{value}")
    public ResponseEntity<List<UserRepresentation>> getUsersByAttributte(@PathVariable String attribute, @PathVariable String value) {
        return ResponseEntity.ok(keycloakService.findByAttributes(attribute, value));
    }

    @PutMapping("/dependencia")
    public ResponseEntity<Void> updateDependencia(@RequestBody UserDto users) {
        keycloakService.updateDependencia(users);
        return ResponseEntity.noContent().build();
    }

}
