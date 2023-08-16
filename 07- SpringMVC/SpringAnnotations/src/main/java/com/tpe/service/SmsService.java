package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component("sms_service")//default bean name:smsService
public class SmsService implements MessageService{

    @PostConstruct//classın const çağrıldıktan sonra metodu çağırır
    public void postConstruct(){
        System.out.println("SmsService objesi oluşturuldu.");
    }

    @PreDestroy//obje imha edilmeden önce metodu çağırır
    public void preDestroy(){
        System.out.println("SmsService objesi imha ediliyor.");
    }

    @Autowired
    private Random random;
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız: "+message.getMessage());

    }

    @Override
    public void saveMessage(Message message) {
        System.out.println(random.nextInt(100));

    }

    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;

    public void printContact(){
        System.out.println("email : "+email);
        System.out.println("phone : "+phone);
    }

}
