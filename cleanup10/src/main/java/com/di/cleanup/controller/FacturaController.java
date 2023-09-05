package com.di.cleanup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.di.cleanup.model.Factura;
import com.di.cleanup.model.Trabajo;
import com.di.cleanup.service.FacturaService;
import com.di.cleanup.service.TrabajoService;

/**
 * Esta clase es la representación del controlador de factura y
 * manejando los distintos usos que se le da a la entidad.
 *
 * @author anghelo
 */


@Controller
@RequestMapping("/factura")
public class FacturaController {

    private final FacturaService facturaService;
    private final TrabajoService trabajoService;

    @Autowired
    public FacturaController(FacturaService facturaService, TrabajoService trabajoService) {
        this.facturaService = facturaService;
        this.trabajoService = trabajoService;
    }

    // Muestra el formulario para crear una factura
    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("factura", new Factura());
        return "crear_factura"; // Nombre de la vista HTML
    }

    // Crea una factura
    @PostMapping("/crear")
    public String crearFactura(Factura factura, Model model) {
        // Asigna la factura a los trabajos relacionados
        for (Trabajo trabajo : factura.getTrabajos()) {
            trabajo.setFactura(factura);
        }

        facturaService.crearFactura(factura);

        return "redirect:/factura/crear";
    }

    // Lista todas las facturas
    @GetMapping("/listar")
    public String listarFacturas(Model model) {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        model.addAttribute("facturas", facturas);
        return "mostrarfactura"; // Nombre de la vista HTML para listar facturas
    }

    // Elimina una factura por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFacturaPorId(id);
        return "redirect:/factura/listar";
    }

    // Muestra los detalles de una factura por su ID
    @GetMapping("/ver/{id}")
    public String verFactura(@PathVariable Long id, Model model) {
        Factura factura = facturaService.obtenerFacturaPorId(id);
        model.addAttribute("factura", factura);
        return "lista_facturas"; // Nombre de la vista HTML para mostrar los detalles de la factura
    }

    // Muestra el formulario para editar una factura por su ID
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Factura factura = facturaService.obtenerFacturaPorId(id);
        model.addAttribute("factura", factura);
        return "eliminar_trabajo"; // Vista HTML para editar factura
    }

    // Edita una factura
    @PostMapping("/editar")
    public String editarFactura(Factura factura, Model model) {
        // Asigna la factura a los trabajos relacionados
        for (Trabajo trabajo : factura.getTrabajos()) {
            trabajo.setFactura(factura);
        }

        facturaService.actualizarFactura(factura);

        return "redirect:/factura/listar";
    }

    // Elimina un trabajo relacionado con una factura por su ID
    @GetMapping("/eliminarTrabajo/{id}")
    public String eliminarTrabajo(@PathVariable Long id) {
        Trabajo trabajo = trabajoService.obtenerTrabajoPorId(id);

        if (trabajo != null && trabajo.getFactura() != null) {
            Factura factura = trabajo.getFactura();
            factura.removerTrabajo(trabajo);
            facturaService.actualizarFactura(factura);

            return "redirect:/factura/editar/" + factura.getId(); // Redirige usando el ID de la factura
        } else {
            // Manejar caso cuando la factura asociada es nula
            return "redirect:/factura/listar"; // O redirige a otra página si es necesario
        }
    }
}
