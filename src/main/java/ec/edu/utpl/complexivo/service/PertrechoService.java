package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Pertrecho;
import org.springframework.data.domain.Page;

public interface PertrechoService {

    void save(Pertrecho pertrecho);

    Page<Pertrecho> getAllPertrecho(Integer page, Integer size);

}
