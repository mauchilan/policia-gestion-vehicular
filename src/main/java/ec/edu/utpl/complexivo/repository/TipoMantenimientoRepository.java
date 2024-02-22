package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.TipoMantenimiento;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMantenimientoRepository extends ListCrudRepository<TipoMantenimiento, Integer> {
}
