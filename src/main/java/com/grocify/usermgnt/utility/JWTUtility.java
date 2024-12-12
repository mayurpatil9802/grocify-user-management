package com.grocify.usermgnt.utility;

import com.grocify.usermgnt.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JWTUtility {

    public String buildJWT(UserDTO userDTO) {
        return Jwts.builder()
                .claim("firstName", userDTO.getFirstName())
                .setIssuer(userDTO.getEmailId())
                .setId(userDTO.getEmailId())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(3, ChronoUnit.HOURS)))
                .compact();
    }

}
