package vshchur.com.spaceScanner.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Optional;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(long userId) {
        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        return Jwts.builder().setClaims(claims)
                .signWith(generateKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    private SecretKey generateKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public Long retrieveUserId(Optional<String> token) {
        if (token.isEmpty()) {
            return null;
        }
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(generateKey()).build().parseClaimsJws(token.get()).getBody();
            return Long.valueOf((Integer) claims.get("userId"));
        } catch (Exception e) {
            return null;
        }
    }

}
