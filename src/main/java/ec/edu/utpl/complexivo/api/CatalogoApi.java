package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Catalogo;
import ec.edu.utpl.complexivo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogo")
public class CatalogoApi {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/lista/{descripcion}/{estado}")
    public ResponseEntity<Catalogo> findCatalogoByDescripcionAndEstado(@PathVariable String descripcion, @PathVariable String estado) {
        return ResponseEntity.ok(catalogoService.findCatalogoByDescripcionAndEstado(descripcion, estado));
    }

}
