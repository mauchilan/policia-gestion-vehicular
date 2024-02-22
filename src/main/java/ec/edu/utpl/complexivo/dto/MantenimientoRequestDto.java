package ec.edu.utpl.complexivo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class MantenimientoRequestDto implements Serializable {

    private Integer id;
    private String estado;
    private List<Integer> tipoMantenimiento;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;

}
