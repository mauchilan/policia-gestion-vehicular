package ec.edu.utpl.complexivo.dto;

import ec.edu.utpl.complexivo.entity.Dependencia;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReporteSugerenciaDto implements Serializable {

    private Integer cantidad;
    private String tipo;
    private Dependencia dependencia;
    private Date fechaInicio;
    private Date fechaFin;

}
