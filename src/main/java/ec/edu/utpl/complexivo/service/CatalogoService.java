package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.entity.Catalogo;

import java.util.List;

public interface CatalogoService {

    Catalogo findCatalogoByDescripcionAndEstado(String descripcion, String estado);

}
