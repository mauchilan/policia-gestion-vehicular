package ec.edu.utpl.complexivo.repository;


import ec.edu.utpl.complexivo.entity.Catalogo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRespository extends ListCrudRepository<Catalogo, Integer> {

    Catalogo findCatalogoByDescripcionAndEstado(String descripcion, String estado);

}
