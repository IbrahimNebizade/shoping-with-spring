package com.company.shoping.service.impl;

import com.company.shoping.dto.CreateTokenCommand;
import com.company.shoping.dto.CreateTokenResponse;
import com.company.shoping.dto.TokenType;
import com.company.shoping.service.TokenService;
import com.company.shoping.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
//    private final JWTUtil jwtUtil;
//    @Value("jwt.token.access.expireInMinutes")
//    private Integer accessTokenExpiration;
//    @Value("jwt.token.refresh.expireInMinutes")
//    private Integer refreshTokenExpiration;
//
//    @Override
//    public CreateTokenResponse createToken(CreateTokenCommand command) {
//        var accessToken = jwtUtil.generateToken(accessTokenExpiration,
//                command.getUserName(),
//                command.getId(),
//                TokenType.ACCESS);
//        var refreshToken = jwtUtil.generateToken(refreshTokenExpiration,
//                command.getUserName(),
//                command.getId(),
//                TokenType.REFRESH);
//        return new CreateTokenResponse(accessToken, refreshToken);
//    }
}
