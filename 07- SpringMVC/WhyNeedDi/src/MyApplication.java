//1-Message classı oluşturalım

import domain.Message;
import repo.DbRepository;
import repo.FileRepository;
import repo.Repository;
import service.MailService;
import service.MessageService;
import service.SMSService;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Siparişiniz kargoya verildi.");

//        //2-service
//        //mesajı maille gönderelim.
//        MailService mailService=new MailService();
//        mailService.sendMessage(message);
//
//        //vazgeçtik, hala SMS kullanan var.
//        SMSService smsService=new SMSService();
//        smsService.sendMessage(message);
//
//        //bu böyle gitmez...interface ?-->uyg bakımı ve geliştirme kolaylaşmış
//        MessageService service=new MailService();
//        service.sendMessage(message);
//
//        //run timeda servis objesini belirleyebilir miyiz
//        MessageService service1=null;
//        String serviceName="Mail Service";
//
//        if (args.length>0){
//            serviceName=args[0];
//        }
//        if (serviceName.equalsIgnoreCase("MailService")){
//
//            service1=new MailService();
//
//        }else if(serviceName.equalsIgnoreCase("SMSService")){
//            service1=new SMSService();
//        }
//        service1.sendMessage(message);

        //message ı kalıcı hale getirmek

        Repository repo=new DbRepository();
        MessageService service=new SMSService(repo);
        service.sendMessage(message);
        service.saveMessage(message);

        MessageService service2=new MailService(repo);
        service.sendMessage(message);
        service.saveMessage(message);

        //loosely coupling için:1-interface,2-DI
        //bakım,geliştirme kolaylaştı,classlar arası bağımlılık azaldı
        //maliyet de kısmen azaldı
        //hala objeyi biz oluşturuyoruz?


    }
}
