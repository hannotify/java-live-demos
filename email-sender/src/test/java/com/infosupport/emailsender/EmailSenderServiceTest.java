package com.infosupport.emailsender;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailSenderServiceTest {

    @Test
    void testSend() throws MessagingException, IOException {
        String body = """
                Hello, hope you're doing well.
                                    
                This is a test email from the email-sender Java project.
                                    
                May the Force be with you,
                Hanno""";
        String subject = "Test email from email-sender";
        var email = new Email();

        email.setSender(new EmailUser("hanno@example.org"));
        email.setRecipient(new EmailUser("recipient@example.org"));
        email.setSubject(subject);
        email.setBody(body);

        GreenMail greenMail = new GreenMail();
        greenMail.start();

        GreenMailUtil.sendTextEmailTest(email.recipient().emailAddress(), email.sender().emailAddress(), email.subject(),
                email.body());

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        var message = greenMail.getReceivedMessages()[0];

        assertThat(subject).isEqualToNormalizingNewlines(message.getSubject());
        assertThat(body).isEqualToNormalizingNewlines(message.getContent().toString());
    }
}