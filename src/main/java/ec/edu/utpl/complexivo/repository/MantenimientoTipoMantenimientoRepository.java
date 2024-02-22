package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.MantenimientoTipoMantenimiento;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientoTipoMantenimientoRepository extends ListCrudRepository<MantenimientoTipoMantenimiento, Integer> {

    List<MantenimientoTipoMantenimiento> findByIdMantenimiento(Integer idMantenimiento);

    void deleteByIdMantenimiento(Integer idMantenimiento);

}
