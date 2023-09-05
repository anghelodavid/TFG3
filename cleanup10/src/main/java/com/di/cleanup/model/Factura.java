package com.di.cleanup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta clase se encarga de crear las entidades a traves de objetos java
 *  que se usaran en la aplicación.
 * @author anghelo
 *
 */

@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "dni")
    private String dni;
    @Column(name = "estado")
    private String estado;

    // Relación uno a muchos con la entidad Trabajo
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabajo> trabajos = new ArrayList<>();

    public Factura() {
        // Constructor vacío requerido por JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    // Agrega un trabajo a la lista de trabajos asociados a esta factura
    public void agregarTrabajo(Trabajo trabajo) {
        trabajo.setFactura(this);
        trabajos.add(trabajo);
    }

    // Remueve un trabajo de la lista de trabajos asociados a esta factura
    public void removerTrabajo(Trabajo trabajo) {
        trabajo.setFactura(null);
        trabajos.remove(trabajo);
    }
}
