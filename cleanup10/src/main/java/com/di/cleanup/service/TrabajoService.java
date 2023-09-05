package com.di.cleanup.service;

import java.util.List;

import com.di.cleanup.model.Trabajo;

/**
 * Esta interfaz define los métodos que debe proporcionar un servicio relacionado con la entidad Trabajo.
 * Incluye métodos para crear, obtener, eliminar y otros relacionados con la entidad Trabajo.
 * 
 * Define la interfaz del servicio para gestionar operaciones relacionadas con Trabajo en la aplicación.
 * 
 * @author anghelo
 *
 */
public interface TrabajoService {
    // Método para crear un trabajo
    Trabajo crearTrabajo(Trabajo trabajo);

    // Método para obtener todos los trabajos
    List<Trabajo> obtenerTodosLosTrabajos();

    // Método para obtener un trabajo por su ID
    Trabajo obtenerTrabajoPorId(Long id);

    // Otros métodos relacionados con la entidad Trabajo

    // Método para eliminar un trabajo por su ID
    void eliminarTrabajoPorId(Long idTrabajo);
}
