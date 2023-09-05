package com.di.cleanup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.di.cleanup.model.Trabajo;

/**
 * Esta interfaz proporciona métodos para acceder a las operaciones básicas del CRUD
 * relacionadas con la entidad Trabajo.
 * 
 * Puedes agregar métodos personalizados si es necesario para consultas específicas.
 * 
 * Repositorio de acceso a datos para la entidad Trabajo.
 * 
 * @author anghelo
 *
 */
@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
    // Aquí podrías agregar métodos personalizados si es necesario
}
