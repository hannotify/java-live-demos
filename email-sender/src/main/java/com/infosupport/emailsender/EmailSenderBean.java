package com.infosupport.emailsender;

import jakarta.ejb.Stateless;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;

@Stateless
public class EmailSenderBean implements EmailSender {
    @Override
    public void send(Email email) {
        try {
            Transport.send(email.toMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-- Email sent to %s! --".formatted(email.recipient()));
    }
}
