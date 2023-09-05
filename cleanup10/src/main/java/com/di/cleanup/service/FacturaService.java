package com.di.cleanup.service;

import java.util.List;

import com.di.cleanup.model.Factura;
import com.di.cleanup.model.Trabajo;

/**
 * Esta interfaz define los métodos que debe proporcionar un servicio relacionado con la entidad Factura.
 * Incluye métodos para crear, obtener, eliminar y actualizar facturas, así como para editar facturas y eliminar trabajos.
 * 
 * Define la interfaz del servicio para gestionar las operaciones relacionadas con Factura en la aplicación.
 * 
 * @author anghelo
 *
 */
public interface FacturaService {
    // Método para crear una factura
    void crearFactura(Factura factura);

    // Método para obtener todas las facturas
    List<Factura> obtenerTodasLasFacturas();

    // Método para obtener una factura por su ID
    Factura obtenerFacturaPorId(Long id);

    // Método para eliminar una factura por su ID
    void eliminarFacturaPorId(Long id);

    // Método para actualizar una factura
    void actualizarFactura(Factura factura);

    // Método para editar una factura con trabajos
    void editarFactura(Factura factura, List<Long> trabajosAEliminar, List<Trabajo> nuevosTrabajos);

    // Método para eliminar un trabajo por su ID
    void eliminarTrabajoPorId(Long idTrabajo);
}
