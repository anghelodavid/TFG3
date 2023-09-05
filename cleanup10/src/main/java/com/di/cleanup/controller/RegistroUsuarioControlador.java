package com.di.cleanup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.di.cleanup.controller.dto.UsuarioRegistroDTO;
import com.di.cleanup.service.UsuarioServicio;

/**
 * Esta clase es la representación del controlador de registro y maneja
 * que los usuarios se registren correctamente
 * @author anghelo
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    // Crea un nuevo objeto UsuarioRegistroDTO y lo agrega al modelo
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    // Muestra el formulario de registro
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    // Procesa el formulario de registro
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") @Validated UsuarioRegistroDTO registroDTO, BindingResult bindingResult, Model model) {
        // Validación personalizada de la contraseña
        if (!isValidPassword(registroDTO.getPassword())) {
            bindingResult.rejectValue("password", "error.usuario", "La contraseña debe tener al menos 7 caracteres, una mayúscula y un número");
        }

        if (bindingResult.hasErrors()) {
            return "registro"; // Devuelve la vista de registro con mensajes de error.
        }

        // Aquí puedes guardar el usuario en la base de datos si la contraseña es válida.
        usuarioServicio.guardar(registroDTO);

        return "redirect:/registro?exito";
    }

    // Verifica si una contraseña cumple con ciertos requisitos personalizados
    private boolean isValidPassword(String password) {
        // Verifica si la contraseña cumple con los nuevos requisitos
        return password != null && password.length() >= 7 && 
               password.matches(".*\\d.*") && password.matches(".*[A-Z].*");
    }
}
