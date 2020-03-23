package com.bm.test.bm_test.config;

// vendors
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bm.test.bm_test.constants.Security;
import com.bm.test.bm_test.model.User;
import com.bm.test.bm_test.model.dto.VideoForm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final Algorithm signAlgorithm = Algorithm.HMAC256(Security.SECRET);

    public JwtTokenProvider() { }

    public String generateJWTToken(User user) {
        String accessToken = JWT.create()
                .withIssuer(Security.ISSUER)
                .withClaim("user_name", user.getUserName())
                .withClaim("first_name", user.getFirsName())
                .withClaim("last_name", user.getLastName())
                .withExpiresAt(new Date(System.currentTimeMillis() + Security.EXPIRATION_TIME))
                .sign(this.signAlgorithm);
        return accessToken;
    }

    public void validateToken(String token) throws Exception {
        JWTVerifier verifier = JWT
                .require(this.signAlgorithm)
                .withIssuer(Security.ISSUER)
                .build();

        verifier.verify(token);
    }

    public String getUsernameFromToken(String token) {
        DecodedJWT decodedToken = JWT.decode(token);
        return decodedToken.getClaim("user_name").asString();
    }
}
