package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Integer idCatalogo;
    @Column(name = "cat_id_catalogo")
    private Integer catIdCatalogo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    //@ManyToOne
    //private Catalogo catIdCatalogoP;
    @OneToMany(mappedBy = "catIdCatalogo")
    private List<Catalogo> childs;

}
