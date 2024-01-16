package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    @Column(name = "id_personal")
    private String idPersonal;
    @Column(name = "id_vehichulo")
    private Integer idVehichulo;
    @Column(name = "id_tipo_mantemiento")
    private Integer idTipoMantemiento;
    @Column(name = "km_actual")
    private Integer kmActual;
    private String observaciones;
    @Column(name = "fecha_mantenimiento")
    private Date fechaMantenimiento;
    @Column(name = "hora_mantenimiento")
    private Date horaMantenimiento;
    @Column(name = "proximo_kilometraje")
    private Integer proximoKilometraje;
    @Column(name = "usuario_entrega")
    private String usuarioEntrega;
    @Column(name = "usuario_retira")
    private String usuarioRetira;
    @Column(name = "costo_total")
    private String costoTotal;

}
