package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.VehiculoPersonal;
import ec.edu.utpl.complexivo.repository.VehiculoPersonalRepository;
import ec.edu.utpl.complexivo.service.VehiculoPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehiculoPersonalServiceImpl implements VehiculoPersonalService {

    @Autowired
    private VehiculoPersonalRepository vehiculoPersonalRepository;

    @Override
    public void save(VehiculoPersonal vehiculoPersonal) {
        vehiculoPersonal.setFechaCreacion(new Date());
        vehiculoPersonalRepository.save(vehiculoPersonal);
    }

    @Override
    public List<VehiculoPersonal> findByIdPersonal(String idPersonal) {
        return vehiculoPersonalRepository.findByIdPersonal(idPersonal);
    }

}
