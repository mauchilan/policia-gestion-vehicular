package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.dto.MantenimientoDto;
import ec.edu.utpl.complexivo.dto.MantenimientoRequestDto;
import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.entity.MantenimientoTarea;
import ec.edu.utpl.complexivo.entity.MantenimientoTipoMantenimiento;
import ec.edu.utpl.complexivo.repository.MantenimientoRepository;
import ec.edu.utpl.complexivo.repository.MantenimientoTareaRepository;
import ec.edu.utpl.complexivo.repository.MantenimientoTipoMantenimientoRepository;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import ec.edu.utpl.complexivo.users.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;
    @Autowired
    private MantenimientoTareaRepository mantenimientoTareaRepository;
    @Autowired
    private MantenimientoTipoMantenimientoRepository mantenimientoTipoMantenimientoRepository;
    @Autowired
    private KeycloakService keycloakService;

    @Override
    public Mantenimiento save(Mantenimiento mantenimiento) {
        mantenimiento.setFechaInicio(new Date());
        mantenimiento.setHoraMantenimiento(mantenimiento.getFechaMantenimiento());
        Mantenimiento mantenimientoSave = mantenimientoRepository.save(mantenimiento);
        MantenimientoTarea mantenimientoTarea = new MantenimientoTarea();
        mantenimientoTarea.setIdMantenimiento(mantenimientoSave.getIdMantenimiento());
        mantenimientoTarea.setFechaInicio(new Date());
        mantenimientoTarea.setTarea("Recepcion");
        mantenimientoTarea.setEstado("READY");
        mantenimientoTarea.setUsuarioInicio(mantenimiento.getIdPersonal());
        mantenimientoTareaRepository.save(mantenimientoTarea);
        return mantenimientoSave;
    }

    @Override
    public List<MantenimientoDto> findByEstado(String estado) {
        return mantenimientoRepository.findByEstado(estado).stream().map(mantenimiento -> {
            MantenimientoDto dto = new MantenimientoDto();
            dto.setIdMantenimiento(mantenimiento.getIdMantenimiento());
            dto.setFechaMantenimiento(mantenimiento.getFechaMantenimiento());
            dto.setHoraMantenimiento(mantenimiento.getHoraMantenimiento());
            UserRepresentation user = keycloakService.searchById(mantenimiento.getIdPersonal());
            dto.setSolicitante(user.getFirstName().concat(" ").concat(user.getLastName()));
            dto.setIdSolicitante(user.getAttributes().get("identify").get(0));
            dto.setVehiculo(mantenimiento.getIdVehichulo());
            List<MantenimientoTipoMantenimiento> mantenimientoTipoMantenimientos = mantenimientoTipoMantenimientoRepository.findByIdMantenimiento(mantenimiento.getIdMantenimiento());
            dto.setMantenimientoTipoMantenimientos(mantenimientoTipoMantenimientos);
            dto.setSubtotal(mantenimiento.getSubCosto());
            dto.setIva(mantenimiento.getIva());
            dto.setTotal(mantenimiento.getCostoTotal());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateMantenimiento(MantenimientoRequestDto request) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(request.getId()).get();
        if (!"SN".equals(request.getEstado())) {
            mantenimiento.setEstado(request.getEstado());
        }
        if ("SN".equals(request.getEstado()) || "T".equals(request.getEstado())) {
            mantenimientoTipoMantenimientoRepository.deleteByIdMantenimiento(mantenimiento.getIdMantenimiento());
            request.getTipoMantenimiento().forEach(tipo -> {
                MantenimientoTipoMantenimiento mantenimientoTipoMantenimiento = new MantenimientoTipoMantenimiento();
                mantenimientoTipoMantenimiento.setIdTipoMantenimiento(tipo);
                mantenimientoTipoMantenimiento.setIdMantenimiento(mantenimiento.getIdMantenimiento());
                mantenimientoTipoMantenimientoRepository.save(mantenimientoTipoMantenimiento);
            });
            mantenimiento.setSubCosto(request.getSubtotal());
            mantenimiento.setIva(request.getIva());
            mantenimiento.setCostoTotal(request.getTotal());
            if ("T".equals(request.getEstado())) {
                mantenimiento.setFechaFinal(new Date());
                long diffInMillies = Math.abs(mantenimiento.getFechaFinal().getTime() - mantenimiento.getFechaInicio().getTime());
                mantenimiento.setDuracion(diffInMillies);
            }
        }
        saveTask(mantenimiento);
        mantenimientoRepository.save(mantenimiento);
    }

    private void saveTask(Mantenimiento mantenimiento) {
        MantenimientoTarea mantenimientoTarea = mantenimientoTareaRepository.findByIdMantenimientoAndEstado(mantenimiento.getIdMantenimiento(), "READY");
        String tarea = null;
        if ("R".equals(mantenimiento.getEstado())) {
            tarea = "Registro";
        }
        if ("T".equals((mantenimiento.getEstado()))) {
            tarea = "Orden";
        }
        mantenimientoTarea.setFechaFinal(new Date());
        long diffInMillies = Math.abs(mantenimientoTarea.getFechaFinal().getTime() - mantenimientoTarea.getFechaInicio().getTime());
        mantenimientoTarea.setDuracion(diffInMillies);
        mantenimientoTarea.setEstado("FINISH");
        if (!"F".equals(mantenimientoTarea.getEstado())) {
            mantenimientoTareaRepository.save(mantenimientoTarea);
            MantenimientoTarea mantenimientoTareaNuevo = new MantenimientoTarea();
            mantenimientoTareaNuevo.setIdMantenimiento(mantenimiento.getIdMantenimiento());
            mantenimientoTareaNuevo.setFechaInicio(new Date());
            mantenimientoTareaNuevo.setTarea(tarea);
            mantenimientoTareaNuevo.setEstado("READY");
            //mantenimientoTarea.setUsuarioInicio(mantenimiento.getIdPersonal());
            mantenimientoTareaRepository.save(mantenimientoTareaNuevo);
        }
    }
}
