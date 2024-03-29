package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Catalogo;
import ec.edu.utpl.complexivo.repository.CatalogoRespository;
import ec.edu.utpl.complexivo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    private CatalogoRespository catalogoRespository;

    @Override
    public Catalogo findCatalogoByDescripcionAndEstado(String descripcion, String estado) {
        return catalogoRespository.findCatalogoByDescripcionAndEstado(descripcion, estado);
    }
}
