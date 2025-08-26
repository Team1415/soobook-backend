package com.team1415.soobookbackend.security.jwt.util;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

public class JwtTokenUtils {

    public static JwtParser generateParserFrom(SecretKey key) {
        return Jwts.parser().verifyWith(key).build();
    }


}
