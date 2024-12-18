package com.gym.gym_ver2.infraestructure.controller;

import com.gym.gym_ver2.aplicaction.service.UsuarioService;
import com.gym.gym_ver2.domain.model.entity.Usuario;
import com.gym.gym_ver2.domain.model.pojos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UsuarioControler {
    private final UsuarioService userService;

    @Autowired
    public UsuarioControler(UsuarioService userService) {
        this.userService = userService;
    }

    @GetMapping("/obtenereUsarios")
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuario() {
        List<UsuarioDTO> usuarios = userService.getUsers();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        var userDEaflul = userService.crearUsuarioConRolDefecto(usuario);
        userService.createUser(userDEaflul);
        return ResponseEntity.ok("Usuario creado");
    }
}
