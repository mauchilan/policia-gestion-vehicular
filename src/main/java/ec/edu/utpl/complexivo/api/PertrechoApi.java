package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.entity.Pertrecho;
import ec.edu.utpl.complexivo.repository.PertrechoRepository;
import ec.edu.utpl.complexivo.service.PertrechoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pertrecho")
public class PertrechoApi {

    @Autowired
    private PertrechoService pertrechoService;
    @Autowired
    private PertrechoRepository pertrechoRepository;

    @GetMapping("/pertrechos")
    public ResponseEntity<Page<Pertrecho>> getAllPertrechos(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "15") Integer size){
        return ResponseEntity.ok(pertrechoService.getAllPertrecho(page, size));
    }

    @PostMapping("/crear")
    public ResponseEntity<Void> save(@RequestBody Pertrecho pertrecho){
        pertrechoRepository.save(pertrecho);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/noassign")
    public ResponseEntity<List<Pertrecho>> getAllPertrechoWithouAsggin(){
        return ResponseEntity.ok(pertrechoService.getAllPertrechoWithouAsggin());
    }

    @GetMapping("/personal/{personal}")
    public ResponseEntity<Pertrecho> getPertrechoByIdPersonal(@PathVariable String personal){
        return ResponseEntity.ok(pertrechoService.getPertrechoByIdPersonal(personal));
    }

}

