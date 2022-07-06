package com.company.shoping.service.impl;

import com.company.shoping.dto.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void send(Mail mail){
        var simpleMail=new SimpleMailMessage();
        simpleMail.setTo(mail.getTo());
        simpleMail.setSubject(mail.getSubject());
        simpleMail.setText(mail.getBody());
        mailSender.send(simpleMail);
    }
}
