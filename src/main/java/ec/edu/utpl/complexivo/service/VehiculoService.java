package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehiculoService {

    void createVehiculo(Vehiculo vehiculo);

    void deleteVehiculo(Integer id);

    Page<Vehiculo> getAllVehiculo(Integer page, Integer size);

    void saveAll(List<Vehiculo> vehiculos);

    List<Vehiculo> findByIdDependencia(String idDependencia);

}
