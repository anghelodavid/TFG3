package com.di.cleanup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.cleanup.model.Trabajo;
import com.di.cleanup.repository.TrabajoRepository;

/**
 * Esta clase implementa la interfaz TrabajoService y proporciona la lógica de negocio relacionada con los trabajos.
 * Se encarga de la creación, obtención, eliminación y otros métodos relacionados con la entidad Trabajo.
 * 
 * Implementación del servicio para gestionar operaciones relacionadas con Trabajo en la aplicación.
 * Utiliza el repositorio TrabajoRepository para acceder a los datos de los trabajos.
 * 
 * @author anghelo
 *
 */
@Service
public class TrabajoServiceImpl implements TrabajoService {

    private final TrabajoRepository trabajoRepository;

    @Autowired
    public TrabajoServiceImpl(TrabajoRepository trabajoRepository) {
        this.trabajoRepository = trabajoRepository;
    }

    @Override
    public Trabajo crearTrabajo(Trabajo trabajo) {
        return trabajoRepository.save(trabajo);
    }

    @Override
    public List<Trabajo> obtenerTodosLosTrabajos() {
        return trabajoRepository.findAll();
    }

    @Override
    public Trabajo obtenerTrabajoPorId(Long id) {
        return trabajoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarTrabajoPorId(Long id) {
        trabajoRepository.deleteById(id);
    }

    // Implementa otros métodos relacionados con la entidad Trabajo
}
