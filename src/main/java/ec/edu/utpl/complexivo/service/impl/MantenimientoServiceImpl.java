package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.repository.MantenimientoRepository;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Override
    public void save(Mantenimiento mantenimiento) {
        mantenimiento.setHoraMantenimiento(mantenimiento.getFechaMantenimiento());
        mantenimientoRepository.save(mantenimiento);
    }
}
