package com.di.cleanup.controller.dto;

public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    // Constructor con parámetros para inicializar los campos
    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    // Constructor vacío
    public UsuarioRegistroDTO() {

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
