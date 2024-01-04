package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Localidad;

import java.util.List;

public interface LocalidadService {

    List<Localidad> getAllProvinvias();

    List<Localidad> findByParentLocalidad(Integer parent);

}
