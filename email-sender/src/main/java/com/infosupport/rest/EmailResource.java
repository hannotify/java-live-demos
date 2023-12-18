package com.infosupport.rest;

import com.infosupport.emailsender.Email;
import com.infosupport.emailsender.EmailSender;
import com.infosupport.emailsender.EmailUser;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/email")
public class EmailResource {
    @Inject
    EmailSender emailSender;

    @Inject
    Email email;

    @POST
    public void sendEmail() {
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

        emailSender.send(email);
    }
}
