package com.gym.gym_ver2.infraestructure.auth;

import com.gym.gym_ver2.domain.model.entity.Rol;
import com.gym.gym_ver2.domain.model.entity.Usuario;
import com.gym.gym_ver2.infraestructure.jwt.JwtService;
import com.gym.gym_ver2.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest rq) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(rq.getEmail(), rq.getPassword()));
        Usuario usuario = userRepository.findByEmailUsuario(rq.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

//        UserDetails user = userRepository.findByEmail(rq.getEmail())
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.createToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest rq) {
        Usuario usuario = Usuario.builder()
                .nombreUsuario(rq.getNombreUsuario())
                .apellidoUsuario(rq.getApellidoUsuario())
                .emailUsuario(rq.getEmailUsuario())
                .cedulaUsuario(rq.getCedulaUsuario())
                .estaturaUsuario(rq.getEstaturaUsuario())
                .pesoUsuario(rq.getPesoUsuario())
                .nivelActualUsuario(rq.getNivelActualUsuario())
                .fechaNacimiento( rq.getFechaNacimiento())
                .horasRecompensas(rq.getHorasRecompensas())
                .numeroFicha(rq.getNumeroFicha())
                .contrasenaUsuario( passwordEncoder.encode(rq.getContrasenaUsuario()))
                .idRol(Rol.builder().idRol(1).build())
                .build();

        userRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.createToken(usuario))
                .build();
    }
}
