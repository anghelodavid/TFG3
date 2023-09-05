package com.di.cleanup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.di.cleanup.model.Factura;

/**
 * Esta clase se encarga proporcionar métodos para acceder a las operaciones básicas
 * del CRUD y también permite definir consultas personalizadas.
 * 
 * Además, se define la consulta de eliminación en cascada de trabajos por el ID de factura.
 * 
 * @author anghelo
 *
 */
@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    // Consulta personalizada para buscar una factura por su fecha
    @Query("select p from Factura p where p.fecha like ?1 ")
    public Factura findByName(String string);

    // Método personalizado para eliminar una factura por su ID
    void deleteById(Long id);
}
