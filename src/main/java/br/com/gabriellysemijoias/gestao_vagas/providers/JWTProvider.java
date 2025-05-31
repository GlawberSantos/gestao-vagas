package br.com.gabriellysemijoias.gestao_vagas.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

@Component
public class JWTProvider {

    private static final String SECRET = "seu-segredo-super-seguro"; // Coloque isso em variáveis de ambiente!
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public DecodedJWT validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            return verifier.verify(token.replace("Bearer ", ""));
        } catch (Exception e) {
            return null; // Token inválido
        }
    }

    // Exemplo adicional: geração de token (opcional)
    public String generateToken(String subject, String role) {
        return JWT.create()
            .withSubject(subject)
            .withClaim("roles", java.util.List.of(role))
            .sign(algorithm);
    }
}
