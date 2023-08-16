package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile uygulama geliştirme HARİKA olacak:)");

        //config classını okur, component scan ile packagedaki tüm componentları tarar ve
        // herbirinden sadece 1 tane bean oluşturur, contextte hazır bekler, bean istendiğinde
        //içine bağımlılık enjekte edilerek gönderilir.
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);


        MessageService service=context.getBean(MailService.class);
       // MessageService service=context.getBean(MessageService.class);//Spring akıllı
        service.sendMessage(message);

        MessageService service2=context.getBean(SmsService.class);
        //MessageService service2=context.getBean("sms_service",MessageService.class);
        service2.sendMessage(message);

        //interface i implemente eden birden fazla class varsa ismi belirtilmeli, aksi halde NoUniqueBean...

        MessageService service3=context.getBean(MailService.class);//MailService biz oluşturmadık
        service3.sendMessage(message);
        service3.saveMessage(message);//Repoyu newlemedik


        //Random random=new Random();
//        Random random=context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        //bean scope
        //singleton
        //sadece 1 tane obje üretilir ve heryerde kullanılır
        //beanin yönetiminden tamamen Spring sorumludur.

        //prototype
        //her istekte yeni obje oluşturulur.
        //beanin life cycleından tamamen Spring sorumlu değildir.
        //beanin imhasından Spring sorumlu DEĞİLDİR.

        MessageService service4=context.getBean(MailService.class);
        MessageService service5=context.getBean(MailService.class);

        if (service4==service5){
            System.out.println("Aynı referanslı objeler");
            System.out.println(service4);
            System.out.println(service5);
        }else {
            System.out.println("Farklı referanslı objeler");
            System.out.println(service4);
            System.out.println(service5);
        }

        SmsService service6=context.getBean(SmsService.class);
        service6.printContact();


     context.close();//singleton scopeundaki tüm beanleri imha eder

    }
}
