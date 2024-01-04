package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "catalogo")
@ToString(exclude = {"childs", "cataloParent"})
@EqualsAndHashCode(exclude = {"childs", "cataloParent"})
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
