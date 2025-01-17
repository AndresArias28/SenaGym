package com.gym.gym_ver2.infraestructure.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="9083889768768768768768768768768768768768768768655645454573";

    public String createToken(UserDetails usuario) {
        return createToken(new HashMap<>(), usuario);
    }

    public String createToken(Map<String, Object> extraClaims, UserDetails user) {

        return Jwts.builder()
                .setClaims(extraClaims) // Información adicional
                .setSubject(user.getUsername()) // Usar el correo como sujeto (identificador único)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // Expira en 24 minutos
                .signWith(getKey(), SignatureAlgorithm.HS256) // Firma con clave secreta
                .compact(); // Generar el token
    }

    private Key getKey() {

        byte[] secretEncode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretEncode);
    }

    public boolean validateToken(String token, UserDetails userDetails) {

        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getClaim(token, Claims::getExpiration).before(new Date());
    }

    public String extractUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver) {

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
}
