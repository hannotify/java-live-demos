package com.infosupport.emailsender;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;

@Singleton
@Startup
public class EmailSenderBean implements EmailSender {
    @Inject
    Email email;

    @PostConstruct
    public void postConstruct() {
        String htmlBody = """
                <p>Hello, hope you are doing well!</p>
                <p>This is a test email from the email-sender Java project.</p>
                <p>May the Force be with you,<br/>
                <em>Hanno</em></p>""";
        String subject = "Test email from email-sender";

        email.setSender(new EmailUser("sender@example.org"));
        email.setRecipient(new EmailUser("hanno@example.org"));
        email.setSubject(subject);
        email.setBody(htmlBody);

        try {
            send(email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(Email email) throws MessagingException {
        Transport.send(email.toMessage());
        System.out.println("-- Email sent to %s! --".formatted(email.recipient()));
    }
}
