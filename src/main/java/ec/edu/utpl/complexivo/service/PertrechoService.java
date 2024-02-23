package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Pertrecho;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PertrechoService {

    void save(Pertrecho pertrecho);

    Pertrecho getPertrechoByIdPersonal(String idPersonal);

    Page<Pertrecho> getAllPertrecho(Integer page, Integer size);

    List<Pertrecho> getAllPertrechoWithouAsggin();

}
