package com.company.shoping.service.impl;

import com.company.shoping.dto.CheckOtpRequest;
import com.company.shoping.dto.CreateOtpResponse;
import com.company.shoping.dto.Mail;
import com.company.shoping.event.MailSender;
import com.company.shoping.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
    private final ApplicationEventPublisher eventPublisher;
    private final ConcurrentHashMap<String, Map<String, LocalDateTime>> otpCache = new ConcurrentHashMap<>();

    @Override
    public CreateOtpResponse createOtp(String mail) {
        var randomPin = (int) (Math.random() * 9000) + 1000;
        String otp = String.valueOf(randomPin);

        eventPublisher.publishEvent(new MailSender(Mail.builder()
                .to(mail)
                .subject("Your OTP code")
                .body("OTP code --> " + otp)
                .build()));
        var sessionId = UUID.randomUUID().toString();
        otpCache.put(sessionId, Map.of(otp, LocalDateTime.now()));

        return CreateOtpResponse.builder()
                .expireInSecond(120)
                .sessionId(sessionId)
                .build();
    }

    @Override
    public void checkOtp(CheckOtpRequest request) {
        var otp = otpCache.get(request.getSessionId());
        var isContain = otp.containsKey(request.getOtpCode());
        if (!isContain) {
            throw new RuntimeException("exception..auth.wrong-otp");
        }
        var expireTime = otp.get(request.getOtpCode());
        if (expireTime.plusSeconds(120).isAfter(LocalDateTime.now())) {
            otpCache.remove(request.getOtpCode());
            throw new RuntimeException("exception.auth.expired-otp");
        }
        otpCache.remove(request.getOtpCode());
    }

}
