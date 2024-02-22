package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    @Column(name = "sub_costo")
    private BigDecimal subCosto;
    private BigDecimal iva;
    @Column(name = "costo_total")
    private BigDecimal costoTotal;
    private String estado;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_final")
    private Date fechaFinal;
    private Long duracion;

}
