package com.di.cleanup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Esta clase se encarga de iniciar la aplicación .
 * @author anghelo
 *
 */

//Anotación que marca esta clase como una clase de inicio de Spring Boot
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

	 // Método principal que se ejecuta al iniciar la aplicación
	 public static void main(String[] args) {
	     // Inicia la aplicación Spring Boot, pasando esta clase y los argumentos de línea de comandos
	     SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
	 }
}
