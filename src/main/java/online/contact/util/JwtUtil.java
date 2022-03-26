package online.contact.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import online.contact.model.collection.UserCollection;
import online.contact.model.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    public String setToken(UserCollection userCollection) {
        final String jwtSecret = mEnvironment.getProperty("JWT_SECRET");
        final Map<String, Object> map = new HashMap<>();

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        final Date dateNow = new Date(System.currentTimeMillis());
        final Date dateExpired = new Date(System.currentTimeMillis() + JWT_EXPIRED);

        map.put("id", userCollection.getId());
        map.put("full_name", userCollection.getFullName());
        map.put("email", userCollection.getEmail());
        map.put("created_at", simpleDateFormat.format(dateNow));
        map.put("expired_at", simpleDateFormat.format(dateExpired));

        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(dateNow)
                .setExpiration(dateExpired)
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
