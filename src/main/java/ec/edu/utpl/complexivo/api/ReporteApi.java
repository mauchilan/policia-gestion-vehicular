package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.dto.ReporteSugerenciaDto;
import ec.edu.utpl.complexivo.service.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteApi {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/sugerencia/{fechaInicio}/{fechaFin}")
    private ResponseEntity<List<ReporteSugerenciaDto>> getCountSugerencia(@PathVariable Date fechaInicio, @PathVariable Date fechaFin) {
        return ResponseEntity.ok(sugerenciaService.getCountSugerencia(fechaInicio, fechaFin));
    }

}
