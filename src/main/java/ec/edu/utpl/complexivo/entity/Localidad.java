package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "localidad")
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private Integer idLocalidad;
    @Column(name = "nombre_localidad")
    private String nombreLocalidad;
    @Column(name = "tipo_localidad")
    private String tipoLocalidad;
    @Column(name = "parent_localidad")
    private Integer parentLocalidad;

}
