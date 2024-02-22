package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "mantenimiento_tipo_mantenimiento")
public class MantenimientoTipoMantenimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento_tipo_mantenimiento")
    private Integer idMantenimientoTipoMantenimiento;
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;

}
