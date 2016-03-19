package com.bay1ts.consumer;

import com.bay1ts.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

@Component
public class Consumer {
    @Autowired
    private MailService mailService;
    @JmsListener(destination = "mail.simplequeue")
    public void sendSimpleMail(Message message) {
        try {
            SimpleMailMessage mailMessage=(SimpleMailMessage)((ObjectMessage)message).getObject();
            mailService.sendSimpleMail(mailMessage);
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("sendMail Failure"+message);
        }
    }
    @JmsListener(destination = "mail.mimequeue")
    public void sendMimeMail(Message message) {
        try {
            MimeMailMessage mailMessage=(MimeMailMessage) ((ObjectMessage)message).getObject();
            mailService.sendMimeMail(mailMessage);
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("sendMail Failure"+message);
        }
    }



}