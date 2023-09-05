package com.di.cleanup.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.di.cleanup.controller.dto.UsuarioRegistroDTO;
import com.di.cleanup.model.Usuario;

/**
 * Esta interfaz define los métodos que debe proporcionar un servicio relacionado con la entidad Usuario.
 * Incluye métodos para guardar un usuario, listar usuarios y otros relacionados con la entidad Usuario.
 * Además, implementa UserDetailsService para la autenticación de usuarios.
 * 
 * Define la interfaz del servicio para gestionar operaciones relacionadas con Usuario en la aplicación.
 * 
 * @author anghelo
 *
 */
public interface UsuarioServicio extends UserDetailsService {

    // Método para guardar un usuario a partir de un DTO de registro
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    // Método para listar todos los usuarios
    public List<Usuario> listarUsuarios();

    // Otros métodos relacionados con la entidad Usuario
}
