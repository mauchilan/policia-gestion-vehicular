package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Vehiculo;
import ec.edu.utpl.complexivo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoApi {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/crear")
    public ResponseEntity<Void> createVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.createVehiculo(vehiculo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idVehiculo}")
    public ResponseEntity<Vehiculo> readById(@PathVariable Integer idVehiculo) {
        return ResponseEntity.ok(vehiculoService.readById(idVehiculo));
    }

    @PostMapping("/vehiculos/read")
    public ResponseEntity<List<Vehiculo>> readByIds(@RequestBody List<Integer> idVehiculo) {
        return ResponseEntity.ok(vehiculoService.readByIds(idVehiculo));
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<Page<Vehiculo>> getAllVehiculo(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "15") Integer size){
        return ResponseEntity.ok(vehiculoService.getAllVehiculo(page, size));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Integer id) {
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/vincular")
    public ResponseEntity<Void> saveAll(@RequestBody List<Vehiculo> vehiculos) {
        vehiculoService.saveAll(vehiculos);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dependencia/{dependencia}")
    public ResponseEntity<List<Vehiculo>> findByIdDependenci(@PathVariable String dependencia) {
        return ResponseEntity.ok(vehiculoService.findByIdDependencia(dependencia));
    }

}
