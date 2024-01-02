package ec.edu.utpl.complexivo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehichulo")
    private Integer idVehichulo;
    //private Integer modelo;
    @Column(name = "id_dependencia")
    private String idDependencia;
    private String placa;
    private String chasis;
    private String motor;
    private Integer kilometraje;
    private String cilindraje;
    @Column(name = "capacidad_carga")
    private Integer capacidadCarga;
    @Column(name = "capacidad_pasajero")
    private Integer capacidadPasajero;
    @ManyToOne
    @JoinColumn(name = "modelo", referencedColumnName = "id_catalogo")
    private Catalogo modelo;
    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo", referencedColumnName = "id_catalogo")
    private Catalogo tipoVehiculo;
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id_catalogo")
    private Catalogo marca;

}
