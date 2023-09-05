package com.di.cleanup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.di.cleanup.service.UsuarioServicio;

/**
 * Esta clase configura la seguridad de la aplicación.
 * Define la autenticación, autorización y las rutas permitidas.
 * 
 * Configuración de seguridad web para proteger la aplicación.
 * Se habilita la autenticación basada en formularios y se especifican las rutas permitidas.
 * También se configura el cifrado de contraseñas utilizando BCrypt.
 * 
 * Autoriza el acceso público a ciertas rutas y requiere autenticación para otras.
 * 
 * Esta clase utiliza el servicio de usuario personalizado (UsuarioServicio) para la autenticación.
 * 
 * @author anghelo
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // Configura el cifrado de contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura la autenticación utilizando el servicio de usuario personalizado y el cifrado de contraseñas
        auth.userDetailsService(usuarioServicio)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configura la autorización de rutas y la configuración de inicio de sesión y cierre de sesión
        http.authorizeRequests()
            .antMatchers(
                "/registro**",
                "/js/**",
                "/logo.jpg/**",
                "/css/**",
                "/img/**"
            )
            .permitAll()
            .antMatchers(
                "/factura/crear", // Permite el acceso a usuarios autenticados a /factura/crear
                "/factura/listar", // Permite el acceso a usuarios autenticados a /factura/listar
                "/eliminar/{id}"
            )
            .authenticated() // Requiere autenticación para estas rutas
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }
}
