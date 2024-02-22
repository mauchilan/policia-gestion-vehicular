package ec.edu.utpl.complexivo.service;

import ec.edu.utpl.complexivo.dto.MantenimientoDto;
import ec.edu.utpl.complexivo.dto.MantenimientoRequestDto;
import ec.edu.utpl.complexivo.entity.Mantenimiento;

import java.util.List;

public interface MantenimientoService {

    Mantenimiento save(Mantenimiento mantenimiento);

    List<MantenimientoDto> findByEstado(String estado);

    void updateMantenimiento(MantenimientoRequestDto request);

}
