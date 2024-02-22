package ec.edu.utpl.complexivo.dto;

import ec.edu.utpl.complexivo.entity.MantenimientoTipoMantenimiento;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class MantenimientoDto implements Serializable {

    private Integer idMantenimiento;
    private String idSolicitante;
    private String solicitante;
    private Date fechaMantenimiento;
    private Date horaMantenimiento;
    private Integer vehiculo;
    private List<MantenimientoTipoMantenimiento> mantenimientoTipoMantenimientos;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;

}
