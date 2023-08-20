package com.team1415.soobookbackend.security.jwt.infrastructure.adapter;

import com.team1415.soobookbackend.security.jwt.domain.JwtClaims;
import com.team1415.soobookbackend.security.jwt.domain.port.JwtTokenPort;
import com.team1415.soobookbackend.security.jwt.util.JsonWebTokenClaimsUtils;
import com.team1415.soobookbackend.security.jwt.util.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonWebTokenJwtTokenAdapter implements JwtTokenPort {

    private final Key key;
    private final SignatureAlgorithm signatureAlgorithm;
    private final JwtParser parser;

    public JsonWebTokenJwtTokenAdapter(String clientSecret, SignatureAlgorithm signatureAlgorithm) {
        this(Decoders.BASE64.decode(clientSecret), signatureAlgorithm);
    }

    private JsonWebTokenJwtTokenAdapter(byte[] clientSecretDecoded,
        SignatureAlgorithm signatureAlgorithm) {
        this(Keys.hmacShaKeyFor(clientSecretDecoded), signatureAlgorithm);
    }

    public JsonWebTokenJwtTokenAdapter(Key key, SignatureAlgorithm signatureAlgorithm) {
        this(key, signatureAlgorithm, JwtTokenUtils.generateParserFrom(key));
    }

    public String generateToken(JwtClaims jwtClaims) {
        return Jwts.builder()
            .setClaims(JsonWebTokenClaimsUtils.claimsFrom(jwtClaims))
            .signWith(key, signatureAlgorithm)
            .compact();
    }

    public JwtClaims parse(String token) {
        final Claims claims = parser.parseClaimsJwt(token).getBody();
        return JsonWebTokenClaimsUtils.jwtClaimsFrom(claims);
    }
}
