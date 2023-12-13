package com.infosupport.emailsender;

import jakarta.mail.MessagingException;

public interface EmailSender {
    void send(Email email) throws MessagingException;
}
