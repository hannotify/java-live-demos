package com.infosupport.emailsender;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import jakarta.ws.rs.core.MediaType;

import java.util.Objects;

@Stateless
public class Email {
    private EmailUser sender;
    private EmailUser recipient;
    private String subject;
    private String body;

    @Resource(lookup = "email/session")
    private Session session;

    public Email() {
    }

    public Email(EmailUser sender, EmailUser recipient, String subject, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public Message toMessage() throws MessagingException {
        var message = new MimeMessage(session);

        message.setFrom(sender.emailAddress());
        message.setRecipients(Message.RecipientType.TO, recipient.emailAddress());
        message.setSubject(subject);
        message.setText(body);
        message.setContent(body, MediaType.TEXT_HTML);

        return message;
    }

    public EmailUser sender() {
        return sender;
    }

    public EmailUser recipient() {
        return recipient;
    }

    public String subject() {
        return subject;
    }

    public String body() {
        return body;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Email) obj;
        return Objects.equals(this.sender, that.sender) &&
                Objects.equals(this.recipient, that.recipient) &&
                Objects.equals(this.subject, that.subject) &&
                Objects.equals(this.body, that.body) &&
                Objects.equals(this.session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, recipient, subject, body, session);
    }

    @Override
    public String toString() {
        return "Email[" +
                "sender=" + sender + ", " +
                "recipient=" + recipient + ", " +
                "subject=" + subject + ", " +
                "body=" + body + ", " +
                "session=" + session + ']';
    }

    public void setSender(EmailUser sender) {
        this.sender = sender;
    }

    public void setRecipient(EmailUser recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
