package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //Bu classta yapılandırma ayarları var
@ComponentScan("com.tpe") //com.tpe nin altındaki bileşenleri tarar ve tanımlar
public class AppConfiguration {
}
