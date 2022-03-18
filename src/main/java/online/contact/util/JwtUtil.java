package online.contact.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil implements Serializable {

    @Autowired
    private Environment mEnvironment;

    private static final Long JWT_EXPIRED = 2_592_000_000L;

    /**
     * This function to generate new jwt token.
     * TODO: Add parameter to insert to token.
     */
    public String setToken() {
        final String jwtSecret = mEnvironment.getProperty("JWT_SECRET");
        final Map<String, Object> map = new HashMap<>();

        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRED))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * This function to get data from token.
     */
    public Claims getToken(String token) {
        final String jwtSecret = mEnvironment.getProperty("JWT_SECRET");
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

}
