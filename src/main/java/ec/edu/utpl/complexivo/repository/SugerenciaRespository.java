package ec.edu.utpl.complexivo.repository;

import ec.edu.utpl.complexivo.entity.Sugerencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SugerenciaRespository extends ListCrudRepository<Sugerencia, Integer> {

    @Query(value = "select dependencia, tipo, count(dependencia)\n" +
            "from sugerencia\n" +
            "where fecha_creacion between :fechaInicio and :fechaFin\n" +
            "group by dependencia, tipo\n" +
            "order by count(dependencia)", nativeQuery = true)
    List<Object[]> getCountSugerencia(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);

}
