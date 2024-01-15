package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.dto.ReporteSugerenciaDto;
import ec.edu.utpl.complexivo.entity.Catalogo;
import ec.edu.utpl.complexivo.entity.Dependencia;
import ec.edu.utpl.complexivo.entity.Sugerencia;
import ec.edu.utpl.complexivo.repository.CatalogoRepository;
import ec.edu.utpl.complexivo.repository.DependenciaRepository;
import ec.edu.utpl.complexivo.repository.SugerenciaRespository;
import ec.edu.utpl.complexivo.service.SugerenciaService;
import ec.edu.utpl.complexivo.util.RepositoryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SugerenciaServiceImpl implements SugerenciaService {

    @Autowired
    private SugerenciaRespository sugerenciaRespository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private DependenciaRepository dependenciaRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void save(Sugerencia sugerencia) {
        sugerencia.setFechaCreacion(new Date());
        sugerenciaRespository.save(sugerencia);
    }

    @Override
    public List<ReporteSugerenciaDto> getCountSugerencia(Date fechaInicio, Date fechaFin) {
        String inicio = simpleDateFormat.format(fechaInicio).concat(" 00:00:00");
        String fin = simpleDateFormat.format(fechaFin).concat(" 12:00:00");
        List<ReporteSugerenciaDto> report = sugerenciaRespository.getCountSugerencia(inicio, fin).stream().map(object -> {
            ReporteSugerenciaDto reporte = new ReporteSugerenciaDto();
            reporte.setFechaInicio(fechaInicio);
            reporte.setFechaFin(fechaFin);
            reporte.setCantidad(RepositoryUtil.integerFromObject(object[2]));
            Catalogo catalogo = catalogoRepository.findById(RepositoryUtil.integerFromObject(object[1])).get();
            reporte.setTipo(catalogo.getDescripcion());
            Dependencia dependencia = dependenciaRepository.findById(RepositoryUtil.stringFromObject(object[0])).get();
            reporte.setDependencia(dependencia);
            return reporte;
        }).collect(Collectors.toList());
        return report;
    }
}
