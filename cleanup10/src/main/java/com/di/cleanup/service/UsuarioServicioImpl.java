package com.di.cleanup.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.di.cleanup.controller.dto.UsuarioRegistroDTO;
import com.di.cleanup.model.Rol;
import com.di.cleanup.model.Usuario;
import com.di.cleanup.repository.UsuarioRepositorio;

/**
 * Esta clase implementa la interfaz UsuarioServicio y proporciona la lógica de negocio relacionada con los usuarios.
 * Se encarga de guardar usuarios, autenticar usuarios, y mapear roles a autoridades.
 * 
 * Implementación del servicio para gestionar operaciones relacionadas con Usuario en la aplicación.
 * Utiliza el repositorio UsuarioRepositorio para acceder a los datos de los usuarios.
 * Utiliza BCryptPasswordEncoder para codificar las contraseñas antes de almacenarlas.
 * 
 * Además, implementa la interfaz UserDetailsService para la autenticación de usuarios.
 * 
 * @author anghelo
 *
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
            registroDTO.getApellido(), registroDTO.getEmail(),
            passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}
