package com.tpe.service;

import com.tpe.domain.Message;

import com.tpe.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//class level:bu classın objesinin yönetimi Spring tarafıondan olacak
@Scope("singleton")//default:singleton
public class MailService implements MessageService{

    @PostConstruct//classın const çağrıldıktan sonra metodu çağırır
    public void postConstruct(){
        System.out.println("MailService objesi oluşturuldu.");
    }

    @PreDestroy//obje imha edilmeden önce metodu çağırır
    public void preDestroy(){
        System.out.println("MailService objesi imha ediliyor.");
    }


    //field injection
//    @Autowired//repo objesinin MailService objesine enjekte edilmesini sağlar:DI
//    @Qualifier("fileRepository")//1 den fazla implementasyonu belirleyici görevi görür
//    private Repository repo;


    //setter injection
//    @Autowired
//    @Qualifier("fileRepository")
//    private Repository repo;
//
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }

    //constructor injection:daha güvenli,daha anlaşılır,test etmek daha kolay

    private Repository repo;
    @Autowired//classın sadece 1 tane const varsa opsiyonel
    public MailService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir Mail servisiyim. Mesajınız: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
          repo.save(message);
    }
}
