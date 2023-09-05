package com.di.cleanup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.di.cleanup.model.Usuario;

/**
 * Esta interfaz proporciona métodos para acceder a las operaciones básicas del CRUD
 * relacionadas con la entidad Usuario.
 * 
 * Además, incluye un método personalizado para buscar un usuario por su dirección de correo electrónico.
 * 
 * Repositorio de acceso a datos para la entidad Usuario.
 * 
 * @author anghelo
 *
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    // Método personalizado para buscar un usuario por su dirección de correo electrónico
    public Usuario findByEmail(String email);
}
