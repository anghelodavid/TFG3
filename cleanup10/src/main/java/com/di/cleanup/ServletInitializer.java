package com.di.cleanup;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Esta clase se encarga de iniciar el servlet.
 * Extiende la clase SpringBootServletInitializer, que es una parte de Spring Boot
 * que permite que la aplicación Spring Boot se ejecute como un servlet.
 *
 * @author anghelo
 */
public class ServletInitializer extends SpringBootServletInitializer {
    
    // Configura la aplicación para implementarla como un servlet
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Devuelve la clase principal de la aplicación para la implementación del servlet
        // En este caso, la clase principal es RegistroUsuariosSpringSecurityApplication
        return application.sources(RegistroUsuariosSpringSecurityApplication.class);
    }
}
