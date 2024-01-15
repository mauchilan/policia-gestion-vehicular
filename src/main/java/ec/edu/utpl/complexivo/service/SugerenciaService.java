package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.dto.ReporteSugerenciaDto;
import ec.edu.utpl.complexivo.entity.Sugerencia;

import java.util.Date;
import java.util.List;

public interface SugerenciaService {

    void save(Sugerencia sugerencia);

    List<ReporteSugerenciaDto> getCountSugerencia(Date fechaInicio, Date fechaFin);

}
