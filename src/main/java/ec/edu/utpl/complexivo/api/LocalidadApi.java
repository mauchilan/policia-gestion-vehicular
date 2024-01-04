package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Localidad;
import ec.edu.utpl.complexivo.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidad")
public class LocalidadApi {

    @Autowired
    private LocalidadService localidadService;

    @GetMapping("/provincias")
    public ResponseEntity<List<Localidad>> getAllProvinvias() {
        return ResponseEntity.ok(localidadService.getAllProvinvias());
    }

    @GetMapping("/localidades/{parent}")
    public ResponseEntity<List<Localidad>> findByParentLocalidad(@PathVariable Integer parent) {
        return ResponseEntity.ok(localidadService.findByParentLocalidad(parent));
    }

}
