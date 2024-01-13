package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Vehiculo;
import ec.edu.utpl.complexivo.repository.VehiculoRepository;
import ec.edu.utpl.complexivo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public void createVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo readById(Integer idVehiculo) {
        return vehiculoRepository.findById(idVehiculo).orElse(null);
    }

    @Override
    public List<Vehiculo> readByIds(List<Integer> idVehiculos) {
        return vehiculoRepository.findAllById(idVehiculos);
    }

    @Override
    public void deleteVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    public Page<Vehiculo> getAllVehiculo(Integer page, Integer size) {
        return vehiculoRepository.findAll(PageRequest.of(page, size));
    }

    public void saveAll(List<Vehiculo> vehiculos) {
        vehiculoRepository.saveAll(vehiculos);
    }

    @Override
    public List<Vehiculo> findByIdDependencia(String idDependencia) {
        return vehiculoRepository.findByIdDependencia(idDependencia);
    }
}
