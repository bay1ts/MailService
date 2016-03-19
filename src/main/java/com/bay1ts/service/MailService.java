package com.bay1ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * Created by chenuu on 2016/3/19.
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendSimpleMail(SimpleMailMessage message) throws JMSException {
        javaMailSender.send(message);
        System.out.println("发送邮件成功");
    }
    public void sendMimeMail(MimeMailMessage message) throws JMSException {
        javaMailSender.send((MimeMessagePreparator) message);
        System.out.println("发送邮件成功");
    }
}
