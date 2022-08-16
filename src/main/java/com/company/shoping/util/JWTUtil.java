package com.company.shoping.util;

import com.company.shoping.dto.TokenType;
import com.company.shoping.dto.UserDTO;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JWTUtil {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.issuer}")
    private String issuer;

    public String generateToken(Integer expirationInMinutes, String userName, Long id, TokenType tokenType) {
        try {
            var signer = new MACSigner(secretKey);
            var issuedTime = new Date();
            var expiredTime = new Date(issuedTime.getTime() + expirationInMinutes + 60 * 1000);
            var claimSet = new JWTClaimsSet.Builder()
                    .subject(id.toString())
                    .issuer(this.issuer)
                    .issueTime(issuedTime)
                    .expirationTime(expiredTime)
                    .claim("tokenType", tokenType)
                    .claim("user", new UserDTO(List.of(), userName, id))
                    .build();
            var signedJwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimSet);
            signedJwt.sign(signer);
            return signedJwt.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
