package com.di.cleanup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase se encarga de crear las entidades a traves de objetos java
 *  que se usaran en la aplicación.
 * @author anghelo
 *
 */


@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Constructor con parámetros para inicializar los campos
    public Rol(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor vacío
    public Rol() {

    }

    // Constructor con un parámetro para establecer el nombre del rol
    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }

    // Métodos getters y setters para los campos de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
