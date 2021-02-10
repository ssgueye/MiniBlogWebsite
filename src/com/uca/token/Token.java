package com.uca.token;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.*;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.security.NoSuchAlgorithmException;

/*
    Our simple static class that demonstrates how to create and decode JWTs.
 */
public class Token {

     private static String SECRET_KEY = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

    //Sample method to construct a JWT
    public static String createJWT(String user_name, String uuid) throws NoSuchAlgorithmException{
        
        Map<String, String> content = new HashMap<>();
        content.put("user_name", user_name);
        content.put("uuid", uuid);
        content.put("uuid", uuid);
        content.put("uuid", uuid);

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        

        return Jwts.builder().setClaims(content)
                .setId(UUID.randomUUID().toString())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60  * 60))
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

    public static Map<String, String> decode(String token) throws NoSuchAlgorithmException{

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        Map<String, String> map = new HashMap<>();
        map.put("user_name", claims.get("user_name", String.class));
        map.put("uuid", claims.get("uuid", String.class));

        return map;
    }
}