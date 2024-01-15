package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Catalogo;
import ec.edu.utpl.complexivo.entity.Dependencia;
import ec.edu.utpl.complexivo.entity.Localidad;
import ec.edu.utpl.complexivo.entity.Sugerencia;
import ec.edu.utpl.complexivo.service.CatalogoService;
import ec.edu.utpl.complexivo.service.DependenciaService;
import ec.edu.utpl.complexivo.service.LocalidadService;
import ec.edu.utpl.complexivo.service.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sugerencia")
public class SugerenciaApi {

    @Autowired
    private LocalidadService localidadService;
    @Autowired
    private DependenciaService dependenciaService;
    @Autowired
    private CatalogoService catalogoService;
    @Autowired
    private SugerenciaService sugerenciaService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Sugerencia sugerencia) {
        sugerenciaService.save(sugerencia);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/provincias")
    public ResponseEntity<List<Localidad>> getAllProvinvias() {
        return ResponseEntity.ok(localidadService.getAllProvinvias());
    }

    @PostMapping("/localidad")
    public ResponseEntity<List<Dependencia>> findByLocalidad(@RequestBody Localidad localidad) {
        return ResponseEntity.ok(dependenciaService.findByLocalidad(localidad));
    }

    @GetMapping("/parent/{parentDependencia}")
    public ResponseEntity<List<Dependencia>> findByParentDependencia(@PathVariable String parentDependencia) {
        return ResponseEntity.ok(dependenciaService.findByParentDependencia(parentDependencia));
    }

    @GetMapping("/lista/{descripcion}/{estado}")
    public ResponseEntity<Catalogo> findCatalogoByDescripcionAndEstado(@PathVariable String descripcion, @PathVariable String estado) {
        return ResponseEntity.ok(catalogoService.findCatalogoByDescripcionAndEstado(descripcion, estado));
    }

}
