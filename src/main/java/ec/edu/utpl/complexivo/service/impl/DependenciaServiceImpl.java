package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Dependencia;
import ec.edu.utpl.complexivo.entity.Localidad;
import ec.edu.utpl.complexivo.repository.DependenciaRepository;
import ec.edu.utpl.complexivo.service.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenciaServiceImpl implements DependenciaService {

    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Override
    public void saveAndUpdateDependencia(Dependencia dependencia) {
        dependenciaRepository.save(dependencia);
    }

    @Override
    public void deleteDependencia(String idDependencia) {
        dependenciaRepository.deleteById(idDependencia);
    }

    @Override
    public List<Dependencia> findByTipoDependencia(String tipoDependencia) {
        return dependenciaRepository.findByTipoDependencia(tipoDependencia);
    }

    @Override
    public List<Dependencia> findByLocalidad(Localidad localidad) {
        return dependenciaRepository.findByLocalidad(localidad);
    }

    @Override
    public List<Dependencia> findByParentDependencia(String parentDependencia) {
        return dependenciaRepository.findByParentDependencia(parentDependencia);
    }
}
