package ec.edu.utpl.complexivo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;

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
