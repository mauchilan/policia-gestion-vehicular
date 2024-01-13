package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.VehiculoPersonal;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface VehiculoPersonalRepository extends ListCrudRepository<VehiculoPersonal, Integer> {

    long countByIdVehiculo(Integer idVehiculo);

    List<VehiculoPersonal> findByIdPersonal(String idPersonal);

}
