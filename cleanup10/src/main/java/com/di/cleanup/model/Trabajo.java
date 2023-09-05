package com.di.cleanup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Esta clase se encarga de crear las entidades a traves de objetos java
 *  que se usaran en la aplicación.
 * @author anghelo
 *
 */

@Entity
@Table(name = "Trabajo")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación muchos a uno con la entidad Factura
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Column(name = "descripcion_trabajo")
    private String descripcionTrabajo;

    @Column(name = "precio_trabajo")
    private String precioTrabajo;

    // Métodos getters y setters para los campos de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public String getPrecioTrabajo() {
        return precioTrabajo;
    }

    public void setPrecioTrabajo(String precioTrabajo) {
        this.precioTrabajo = precioTrabajo;
    }
}
