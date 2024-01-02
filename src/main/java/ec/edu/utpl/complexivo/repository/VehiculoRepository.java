package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Vehiculo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends ListCrudRepository<Vehiculo, Integer>, PagingAndSortingRepository<Vehiculo, Integer> {

}
