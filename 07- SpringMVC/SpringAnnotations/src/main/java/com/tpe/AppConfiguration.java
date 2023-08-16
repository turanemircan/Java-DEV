package com.tpe;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default:"com.tpe"(AppConfig in içinde olduğu package)
@PropertySource("classpath:application.properties")//properties dosyasının kaynak olarak okunmasını sağlar
public class AppConfiguration {

    @Bean//thirdparty classlardan bean oluşturur
    public Random random(){
        return new Random();
    }


}
