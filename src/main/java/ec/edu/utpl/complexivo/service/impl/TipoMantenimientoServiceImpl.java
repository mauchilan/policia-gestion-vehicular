package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.TipoMantenimiento;
import ec.edu.utpl.complexivo.repository.TipoMantenimientoRepository;
import ec.edu.utpl.complexivo.service.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMantenimientoServiceImpl implements TipoMantenimientoService {

    @Autowired
    private TipoMantenimientoRepository tipoMantenimientoRepository;

    @Override
    public List<TipoMantenimiento> getAllTipoService() {
        return tipoMantenimientoRepository.findAll();
    }

}
