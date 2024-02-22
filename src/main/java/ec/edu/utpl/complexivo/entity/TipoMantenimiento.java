package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tipo_mantenimiento")
public class TipoMantenimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;
    @Column(name = "tipo_mantenimiento")
    private String tipoMantenimiento;
    @Column(name = "descripcion_mantenimiento")
    private String descripcionMantenimiento;
    private BigDecimal costo;

}
