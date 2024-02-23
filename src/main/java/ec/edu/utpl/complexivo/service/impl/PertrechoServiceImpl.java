package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Pertrecho;
import ec.edu.utpl.complexivo.repository.PertrechoRepository;
import ec.edu.utpl.complexivo.service.PertrechoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PertrechoServiceImpl implements PertrechoService {

    @Autowired
    private PertrechoRepository pertrechoRepository;

    @Override
    public void save(Pertrecho pertrecho) {
        pertrechoRepository.save(pertrecho);
    }

    @Override
    public Pertrecho getPertrechoByIdPersonal(String idPersonal) {
        return pertrechoRepository.getPertrechoByIdPersonal(idPersonal);
    }

    @Override
    public Page<Pertrecho> getAllPertrecho(Integer page, Integer size) {
        return pertrechoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Pertrecho> getAllPertrechoWithouAsggin() {
        return pertrechoRepository.getAllByIdPersonalIsNull();
    }
}
