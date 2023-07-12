package com.example.TokoKu.utility;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtToken {

    private String SECRET_KEY="liberate-tutume-ex-inferis-ad-astra-per-aspera";

    private String AUDIENCE= "Tokoku";


    private Claims getClaims(String token){
        JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY);
        Jws<Claims> signatureAndClaims = jwtParser.parseClaimsJws(token);
        Claims claims = signatureAndClaims.getBody();
        return claims;
    }

    public String getUsername(String token){
        Claims claims = getClaims(token);
        return claims.get("username",String.class);
    }

    public String generateToken(String subject, String username,String secretKey,String role,String audience){
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder = jwtBuilder.setSubject(subject)
                .claim("username",username)
                .claim("role",role)
                .setIssuer("http://localhost:7085")
                .setAudience(audience)
                .signWith(SignatureAlgorithm.HS256,secretKey);
        return jwtBuilder.compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        Claims claims = getClaims(token);
        String user = claims.get("username",String.class);
        String audience = claims.getAudience();
        return (user.equals(userDetails.getUsername()) && audience.equals(AUDIENCE));
    }
}
