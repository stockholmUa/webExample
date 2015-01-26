package com.sourceit.webtasks.services;


public interface EmailService {
    void sendMessage(String recipient, String subject, String emailBody);
}