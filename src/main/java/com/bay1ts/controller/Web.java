package com.bay1ts.controller;

import com.bay1ts.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Created by chenuu on 2016/3/19.
 */
@RestController
@RequestMapping("sendmail")
public class Web {
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "simple",method = RequestMethod.POST)
    public String sendSimpleMail(SimpleMailMessage simpleMailMessage) {
        try {
            mailService.sendSimpleMail(simpleMailMessage);
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("sendMail Failure"+simpleMailMessage);
            return "failure";
        }
        return "success";
    }
    //暂不开放
//    @RequestMapping(value = "mime",method = RequestMethod.POST)
    public String sendMimeMail(MimeMailMessage message) {
        try {
            mailService.sendMimeMail(message);
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("sendMail Failure"+message);
            return "failure";
        }
        return "success";
    }
}
