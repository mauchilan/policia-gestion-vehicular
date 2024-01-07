package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Dependencia;
import ec.edu.utpl.complexivo.entity.Localidad;
import ec.edu.utpl.complexivo.service.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencia")
public class DependenciaApi {

    @Autowired
    private DependenciaService dependenciaService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveAndUpdateDependencia(@RequestBody Dependencia dependencia){
        dependenciaService.saveAndUpdateDependencia(dependencia);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/delete/{idDependencia}")
    public ResponseEntity<Void> deleteDependencia(@PathVariable String idDependencia){
        dependenciaService.deleteDependencia(idDependencia);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dependencias/{tipoDependencia}")
    public ResponseEntity<List<Dependencia>> findByTipoDependencia(@PathVariable String tipoDependencia){
        return ResponseEntity.ok(dependenciaService.findByTipoDependencia(tipoDependencia));
    }

    @PostMapping("/localidad")
    public ResponseEntity<List<Dependencia>> findByLocalidad(@RequestBody Localidad localidad) {
        return ResponseEntity.ok(dependenciaService.findByLocalidad(localidad));
    }

    @GetMapping("/parent/{parentDependencia}")
    public ResponseEntity<List<Dependencia>> findByParentDependencia(@PathVariable String parentDependencia) {
        return ResponseEntity.ok(dependenciaService.findByParentDependencia(parentDependencia));
    }


}
