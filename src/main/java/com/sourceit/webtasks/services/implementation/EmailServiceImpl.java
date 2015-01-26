package com.sourceit.webtasks.services.implementation;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sourceit.webtasks.services.EmailService;

import java.util.Properties;

public class EmailServiceImpl implements EmailService {
    Session mailSession;

    public EmailServiceImpl() {
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");

        mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("account@gmail.com", "password");
                    }
                });
    }

    public void sendMessage(String recipient, String subject, String emailBody) {
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setSubject(subject);
            message.setFrom(new InternetAddress("webProject.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setContent(emailBody,"text/html");

            postMessage(message);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void postMessage(MimeMessage message) {
        try {
            Transport transport = mailSession.getTransport();
            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch(Exception e) {
            // TODO add logging
            e.printStackTrace();
        }
    }
}
