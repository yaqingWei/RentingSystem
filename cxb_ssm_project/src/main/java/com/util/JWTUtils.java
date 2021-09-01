package com.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import jdk.nashorn.internal.parser.Token;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Xiaobo
 * @create 2021-08-17 9:49
 * 令牌验证
 */
public class JWTUtils {
    private static final String SIGN = "qweddwqd1!343%^^$##HGFFFFFFFFFFFFFDDGHHBFRRttdjdsdjsd";

    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("typ", "JWT");
        hashMap.put("alg", "HS256");
        builder.withHeader(hashMap);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        builder.withExpiresAt(cal.getTime());
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                builder.withClaim(s, s2);
            }
        });
       return builder.sign(Algorithm.HMAC256(SIGN));
    }

    public static DecodedJWT checkJWT(String token){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
        DecodedJWT verify = build.verify(token);
        return verify;
    }

}
