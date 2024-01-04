package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dependencia")
public class Dependencia {

    @Id
    @Column(name = "id_dependencia")
    private String idDependencia;
    @Column(name = "nombre_dependencia")
    private String nombreDependencia;
    @Column(name = "tipo_dependencia")
    private String tipoDependencia;
    @Column(name = "numero_dependencia")
    private Integer numeroDependencia;
    @Column(name = "parent_dependencia")
    private Integer parentDependencia;
    @ManyToOne
    @JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
    private Localidad localidad;

}
