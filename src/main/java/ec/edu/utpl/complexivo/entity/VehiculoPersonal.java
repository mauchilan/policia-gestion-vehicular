package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "vehiculo_personal")
public class VehiculoPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo_personal")
    private Integer idVehiculoPersonal;
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Column(name = "id_personal")
    private String idPersonal;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

}
