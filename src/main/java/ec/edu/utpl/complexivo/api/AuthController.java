package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.security.AuthService;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/permisssion")
    public ResponseEntity<List<ResourceRepresentation>> getPermissions(@RequestHeader("Authorization") String bearerToken) {
        return ResponseEntity.ok(authService.getAuth(bearerToken));
    }

}
