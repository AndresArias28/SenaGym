package com.gym.gym_ver2.infraestructure.jwt;

import com.gym.gym_ver2.domain.model.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final String SECRET_KEY="9083889768768768768768768768768768768768768768655645454573";

    public String createToken(Usuario usuario) {
        return createToken(new HashMap<>(), usuario);
    }


    private String createToken(Map<String, Object> extraClaims, Usuario user) {
        return Jwts
                .builder()
                .setClaims(extraClaims) // Información adicional
                .setSubject(user.getEmailUsuario()) // Usar el correo como sujeto (identificador único)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // Expira en 24 minutos
                .signWith(getKey(), SignatureAlgorithm.HS256) // Firma con clave secreta
                .compact(); // Generar el token
    }

    private Key getKey() {
        byte[] secretEncode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretEncode);
    }

}
