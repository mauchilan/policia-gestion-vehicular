package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pertrecho")
public class Pertrecho implements Serializable {

    @Id
    private String codigo;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "tipo_arma", referencedColumnName = "id_catalogo")
    private Catalogo tipoArma;

}
