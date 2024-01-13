package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Column(name = "")
    private Integer id_mantenimiento;
    @Column(name = "")
    private String id_personal;
    @Column(name = "")
    private Integer id_vehichulo;
    @Column(name = "")
    private Integer id_tipo_mantemiento;
    @Column(name = "")
    private Integer km_actuall;
    @Column(name = "")
    private String observaciones;
    @Column(name = "")
    private Date fecha_mantenimiento;
    @Column(name = "")
    private Date hora_mantenimiento;
    @Column(name = "")
    private Integer proximo_kilometraje;
    @Column(name = "")
    private String usuario_entrega;
    @Column(name = "")
    private String usuario_retira;
    @Column(name = "")
    private String costo_total;

}
