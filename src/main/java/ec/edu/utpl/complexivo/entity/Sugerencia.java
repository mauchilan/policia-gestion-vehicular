package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "sugerencia")
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugerencia")
    private Integer idSugerencia;
    private String dependencia;
    private Integer tipo;
    private String detalle;
    private String contacto;
    private String nombres;
    private String apellidos;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_atencion")
    private Date fechaAtencion;

}
