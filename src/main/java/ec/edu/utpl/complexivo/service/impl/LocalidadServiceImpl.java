package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Localidad;
import ec.edu.utpl.complexivo.repository.LocalidadRepository;
import ec.edu.utpl.complexivo.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    @Override
    public List<Localidad> getAllProvinvias() {
        return localidadRepository.getAllProvinvias();
    }

    @Override
    public List<Localidad> findByParentLocalidad(Integer parent) {
        return localidadRepository.findByParentLocalidad(parent);
    }
}
