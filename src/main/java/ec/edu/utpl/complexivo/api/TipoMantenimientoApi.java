package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.TipoMantenimiento;
import ec.edu.utpl.complexivo.service.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-mantenimiento")
public class TipoMantenimientoApi {

    @Autowired
    private TipoMantenimientoService tipoMantenimientoService;

    @GetMapping("/all")
    public ResponseEntity<List<TipoMantenimiento>> allTipoMantenimiento() {
        return ResponseEntity.ok(tipoMantenimientoService.getAllTipoService());
    }

}
