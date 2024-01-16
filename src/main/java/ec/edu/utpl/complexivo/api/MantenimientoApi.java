package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.repository.MantenimientoRepository;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoApi {

    @Autowired
    private MantenimientoService mantenimientoService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Mantenimiento mantenimiento) {
        mantenimientoService.save(mantenimiento);
        return ResponseEntity.noContent().build();
    }

}
