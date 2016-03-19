package com.bay1ts;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJms
public class APP {

    @Bean(name = "simpleMailQueue")
    public Queue SimpleQueue() {
        return new ActiveMQQueue("mail.simplequeue");
    }
    @Bean(name = "mimeMailQueue")
    public Queue MimeQueue(){
        return new ActiveMQQueue("mail.mimequeue");
    }

    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }

}