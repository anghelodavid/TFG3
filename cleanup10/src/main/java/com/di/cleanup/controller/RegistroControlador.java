package com.di.cleanup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.di.cleanup.service.UsuarioServicio;
/**
 * Esta clase es la representación del controlador de registro ymanejando 
 * los distintos usos que se le da a la entidad de usuario una vez
 * que inicia sesión.
 *
 * @author anghelo
 */

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    // Muestra la página de inicio de sesión
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    // Muestra la página de inicio y lista de usuarios
    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }

    // Muestra la página de usuarios y lista de usuarios
    @GetMapping("/users")
    public String verUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "users";
    }
}
