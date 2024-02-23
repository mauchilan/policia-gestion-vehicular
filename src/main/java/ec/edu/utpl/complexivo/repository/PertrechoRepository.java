package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Pertrecho;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PertrechoRepository extends ListCrudRepository<Pertrecho, String>, PagingAndSortingRepository<Pertrecho, String> {

    List<Pertrecho> getAllByIdPersonalIsNull();

    Pertrecho getPertrechoByIdPersonal(String idPersonal);

}
