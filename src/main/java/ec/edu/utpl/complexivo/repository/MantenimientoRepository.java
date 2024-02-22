package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Mantenimiento;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MantenimientoRepository extends ListCrudRepository<Mantenimiento, Integer> {

    List<Mantenimiento> findByEstado(String estado);

}
