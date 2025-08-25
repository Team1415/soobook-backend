package com.team1415.soobookbackend.security.jwt.util;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.security.Key;

public class JwtTokenUtils {

    public static JwtParser generateParserFrom(Key key) {
        return Jwts.parserBuilder().setSigningKey(key).build();
    }


}
