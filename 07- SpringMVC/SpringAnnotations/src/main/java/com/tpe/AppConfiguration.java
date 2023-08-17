package com.tpe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default:"com.tpe"(AppConfig in içinde olduğu package)
@PropertySource("classpath:application.properties")//properties dosyasının kaynak olarak okunmasını sağlar
public class AppConfiguration {

    //Springin interfacei Environment:application.properties içindeki değişkenlere ve
    //uygulamanın çalıştığı tüm ortam değişkenlerine ulaşmamızı sağlar.
    @Autowired
    private Environment environment;


    @Bean//thirdparty classlardan bean oluşturur
    public Random random(){
        return new Random();
    }

    //value anatosyonu ile yaptığımız işlem için Properties classını kullanalım

    @Bean
    public Properties properties(){
        Properties properties=new Properties();//hashtable extend eder
        //properties.put("mymail","techpro@gmail.com");
        properties.put("mymail",environment.getProperty("app.email"));
        properties.put("phone",environment.getProperty("app.phone"));
        return properties;
    }




}
