package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Localidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends ListCrudRepository<Localidad, Integer> {

    @Query(value = "select e from Localidad e where e.parentLocalidad is null")
    List<Localidad> getAllProvinvias();

    List<Localidad> findByParentLocalidad(Integer parent);

}
