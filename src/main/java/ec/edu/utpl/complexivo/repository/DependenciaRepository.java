package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Dependencia;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenciaRepository extends ListCrudRepository<Dependencia, String > {

    List<Dependencia> findByTipoDependencia(String tipoDependencia);

}
