package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.VehiculoPersonal;

import java.util.List;

public interface VehiculoPersonalService {

    void save(VehiculoPersonal vehiculoPersonal);

    List<VehiculoPersonal> findByIdPersonal(String idPersonal);

}
