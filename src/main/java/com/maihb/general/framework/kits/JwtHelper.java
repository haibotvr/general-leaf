package com.maihb.general.framework.kits;

import com.maihb.general.framework.abstracts.AbstractUser;
import com.maihb.general.framework.exception.AuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author simon.wei
 */
public class JwtHelper {

    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    private final static int expiredSecond = 172800000;

    public static Claims parseJWT(String jsonWebToken){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("authentication failed");
        }
    }

    public static String createJWT(AbstractUser user){

        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

        //获取时间戳
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key signKey = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());

        //添加参数
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .claim(LeafConstant.SESSION_USER, user)
                .signWith(algorithm, signKey);

        //添加Token过期时间
        if (expiredSecond >= 0) {
            long expMillis = nowMillis + expiredSecond;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
        return builder.compact();
    }

}
