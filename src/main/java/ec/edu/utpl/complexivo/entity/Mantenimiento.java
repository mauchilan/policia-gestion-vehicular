package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @Column(name = "id_mantenimiento")
    private Integer id_mantenimiento;
    @Column(name = "id_personal")
    private String id_personal;
    @Column(name = "id_vehichulo")
    private Integer id_vehichulo;
    @Column(name = "id_tipo_mantemiento")
    private Integer id_tipo_mantemiento;
    @Column(name = "km_actuall")
    private Integer km_actuall;
    private String observaciones;
    @Column(name = "fecha_mantenimiento")
    private Date fecha_mantenimiento;
    @Column(name = "hora_mantenimiento")
    private Date hora_mantenimiento;
    @Column(name = "proximo_kilometraje")
    private Integer proximo_kilometraje;
    @Column(name = "usuario_entrega")
    private String usuario_entrega;
    @Column(name = "usuario_retira")
    private String usuario_retira;
    @Column(name = "costo_total")
    private String costo_total;

}
