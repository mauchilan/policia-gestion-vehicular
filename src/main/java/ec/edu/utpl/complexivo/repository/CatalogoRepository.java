package ec.edu.utpl.complexivo.repository;


import ec.edu.utpl.complexivo.entity.Catalogo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends ListCrudRepository<Catalogo, Integer> {

    Catalogo findCatalogoByDescripcionAndEstado(String descripcion, String estado);

}
