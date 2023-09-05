package com.di.cleanup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.cleanup.model.Factura;
import com.di.cleanup.model.Trabajo;
import com.di.cleanup.repository.FacturaRepository;

/**
 * Esta clase implementa la interfaz FacturaService y proporciona la lógica de negocio relacionada con las facturas.
 * Se encarga de la creación, obtención, eliminación, actualización y edición de facturas, así como la eliminación de trabajos.
 * 
 * Implementación del servicio para gestionar operaciones relacionadas con Factura en la aplicación.
 * Utiliza el repositorio FacturaRepository para acceder a los datos de las facturas.
 * 
 * @author anghelo
 *
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public void crearFactura(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll(); // Método proporcionado por JPA para obtener todas las facturas
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarFacturaPorId(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public void eliminarTrabajoPorId(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public void actualizarFactura(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public void editarFactura(Factura factura, List<Long> trabajosAEliminar, List<Trabajo> nuevosTrabajos) {
        for (Long trabajoId : trabajosAEliminar) {
            factura.getTrabajos().removeIf(trabajo -> trabajo.getId().equals(trabajoId));
        }

        for (Trabajo nuevoTrabajo : nuevosTrabajos) {
            nuevoTrabajo.setFactura(factura);
            factura.getTrabajos().add(nuevoTrabajo);
        }

        actualizarFactura(factura);
    }
}
