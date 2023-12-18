package com.infosupport.emailsender.it;

import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.infosupport.emailsender.Email;
import com.infosupport.emailsender.EmailUser;
import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class SendEmailIT {
    @RegisterExtension
    static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP);

    @Test
    public void testGet() throws MessagingException, IOException {
        var expectedEmail = buildExpectedEmail();

        given()
                .when().post(restUrl("email"))
                .then()
                .statusCode(204);

        var receivedMessages = greenMail.getReceivedMessages();
        assertThat(receivedMessages).hasSize(1);

        var receivedMessage = receivedMessages[0];
        assertThat(receivedMessage.getSubject()).isEqualTo(expectedEmail.subject());

        Address[] fromRecipients = receivedMessage.getFrom();
        assertThat(fromRecipients).hasSize(1);
        assertThat(fromRecipients[0]).isEqualTo(new InternetAddress(expectedEmail.sender().emailAddress()));

        assertThat(receivedMessage.getContent().toString()).isEqualToNormalizingNewlines(expectedEmail.body());

        Address[] toRecipients = receivedMessage.getRecipients(Message.RecipientType.TO);
        assertThat(toRecipients).hasSize(1);
        assertThat(toRecipients[0]).isEqualTo(new InternetAddress(expectedEmail.recipient().emailAddress()));
    }

    private Email buildExpectedEmail() {
        var body = """
                <p>Hello, hope you are doing well!</p>
                <p>This is a test email from the email-sender Java project.</p>
                <p>May the Force be with you,<br/>
                <em>Hanno</em></p>""";
        var subject = "Test email from email-sender";
        var sender = new EmailUser("sender@example.org");
        var recipient = new EmailUser("hanno@example.org");

        return new Email(sender, recipient, subject, body);
    }

    static String restUrl(String relativeUrl) {
        return "http://localhost:9080/email-sender/api/" + relativeUrl;
    }

}
