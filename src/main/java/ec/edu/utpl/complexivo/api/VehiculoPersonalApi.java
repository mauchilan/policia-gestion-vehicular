package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.VehiculoPersonal;
import ec.edu.utpl.complexivo.service.VehiculoPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo-personal")
public class VehiculoPersonalApi {

    @Autowired
    private VehiculoPersonalService vehiculoPersonalService;

    @PostMapping("/crear")
    public ResponseEntity<Void> createVehiculoPersonal(@RequestBody VehiculoPersonal vehiculoPersonal) {
        vehiculoPersonalService.save(vehiculoPersonal);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/personal/{idPersonal}")
    public ResponseEntity<List<VehiculoPersonal>> findByIdPersonal(@PathVariable String idPersonal) {
        return ResponseEntity.ok(vehiculoPersonalService.findByIdPersonal(idPersonal));
    }

}
