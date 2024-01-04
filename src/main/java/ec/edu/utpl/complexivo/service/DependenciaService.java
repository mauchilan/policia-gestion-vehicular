package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Dependencia;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DependenciaService {

    void saveAndUpdateDependencia(Dependencia dependencia);

    void deleteDependencia(String idDependencia);

    List<Dependencia> findByTipoDependencia(String tipoDependencia);


}
