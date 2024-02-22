package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.MantenimientoTarea;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoTareaRepository extends ListCrudRepository<MantenimientoTarea, Integer> {

    MantenimientoTarea findByIdMantenimientoAndEstado(Integer idMantenimiento, String estado);

}
