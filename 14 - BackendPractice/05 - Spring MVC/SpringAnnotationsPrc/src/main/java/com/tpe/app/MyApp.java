package com.tpe.app;

import com.tpe.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    //configurasyon yapısını bildirmek için context oluşturalım
    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);



}
