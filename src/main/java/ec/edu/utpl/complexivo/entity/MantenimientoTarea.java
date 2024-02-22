package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mantenimiento_tarea")
public class MantenimientoTarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento_tarea")
    private Integer idMantenimientoTarea;
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    private String tarea;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_final")
    private Date fechaFinal;
    @Column(name = "usuario_inicio")
    private String usuarioInicio;
    private Long duracion;
    @Column(name = "usuario_final")
    private String usuarioFinal;
    private String estado;

}
