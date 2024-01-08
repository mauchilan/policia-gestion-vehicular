package ec.edu.utpl.complexivo.dto;

import ec.edu.utpl.complexivo.entity.Dependencia;
import lombok.Data;
import org.keycloak.representations.idm.UserRepresentation;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {

    private List<UserRepresentation> users;
    private Dependencia dependencia;
}
