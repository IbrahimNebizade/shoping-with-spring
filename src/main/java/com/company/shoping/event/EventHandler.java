package com.company.shoping.event;

import com.company.shoping.service.impl.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {
    private final MailService mailService;

    @Async
    @EventListener
    public void mailHandler(MailSender mailSender){
        var mail=mailSender.getMail();
        mailService.send(mail);
    }
}
