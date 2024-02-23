package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pertrecho")
public class Pertrecho implements Serializable {

    @Id
    private String codigo;
    private String nombre;
    private String descripcion;
    @Column(name = "id_personal")
    private String idPersonal;
    @Column(name = "fecha_registro_personal")
    private Date fechaRegistroPersonal;
    @ManyToOne
    @JoinColumn(name = "tipo_arma", referencedColumnName = "id_catalogo")
    private Catalogo tipoArma;

}
