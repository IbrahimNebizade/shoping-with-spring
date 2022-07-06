package com.company.shoping.event;

import com.company.shoping.dto.Mail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MailSender {
    private final Mail mail;
}
