package com.cognizant.jwtauthassignment.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("JwtAuthAssignment")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*1000)) // 1 hour
                .signWith(key)
                .compact();
    }
}
