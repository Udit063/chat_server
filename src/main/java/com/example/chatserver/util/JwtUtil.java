package com.example.chatserver.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String jwtSecret = "6uT9bYzX9LqG8J2VvF5N1PwK3cQ7RxA";

    public String extractUserId(String token) throws SignatureException {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
