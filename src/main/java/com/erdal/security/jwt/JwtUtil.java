package com.erdal.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Gizli anahtar (en az 256 bit olmalı) - üretken ortamda güvenli sakla!
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token geçerlilik süresi (örnek: 10 saat)
    private final long jwtExpirationMs = 10 * 60 * 60 * 1000;

    // Token oluşturma
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)              // Token sahibinin adı (username)
                .setIssuedAt(new Date())           // Token oluşturulma zamanı
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // Son kullanma süresi
                .signWith(secretKey)               // İmzalama algoritması ve anahtarı
                .compact();
    }

    // Token içinden username alma
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // Token geçerliliğini kontrol et
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;  // Token doğru ve geçerli
        } catch (JwtException | IllegalArgumentException e) {
            // Hatalı, süresi geçmiş veya imzası geçersiz token
            return false;
        }
    }

    // Token içinden herhangi bir claim alma yardımcı metodu
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}
