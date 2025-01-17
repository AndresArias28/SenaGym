package com.gym.gym_ver2.aplicaction.service;

import com.gym.gym_ver2.domain.model.entity.Rol;
import com.gym.gym_ver2.domain.model.entity.Usuario;
import com.gym.gym_ver2.domain.model.pojos.UsuarioDTO;
import com.gym.gym_ver2.infraestructure.repository.RolRepository;
import com.gym.gym_ver2.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {

        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public List<UsuarioDTO> getUsers() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(usr -> new UsuarioDTO(
                        usr.getIdUsuario(),
                        usr.getNombreUsuario(), // Nombre
                        usr.getEmailUsuario(),
                        usr.getIdRol().getNombreRol() // NombreUsuario
                ))
                .toList();
    }

    @Override
    public void createUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario crearUsuarioConRolDefecto(Usuario usuario) {

        Rol rolPorDefecto = rolRepository.findById(2)
                .orElseThrow(() -> new IllegalArgumentException("El rol con ID 2 no existe"));
        usuario.setIdRol(rolPorDefecto);
        return usuarioRepository.save(usuario);
    }

}
