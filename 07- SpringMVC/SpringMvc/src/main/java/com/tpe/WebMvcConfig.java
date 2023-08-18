package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe")
@EnableWebMvc//MVC config etkinleştirmek
public class WebMvcConfig implements WebMvcConfigurer {

    //view resolver için bean oluşturulsun
    @Bean
    public InternalResourceViewResolver resolver(){
       InternalResourceViewResolver resolver=new InternalResourceViewResolver();//bir instance oluştur
       resolver.setViewClass(JstlView.class);//JavaStandartTagLibrary:JSP içine daha az kod yazmamızı sağlar
       resolver.setPrefix("/WEB-INF/views/");//view dosyaları nerede
       resolver.setSuffix(".jsp");//view namein uzantısını belirliyoruz
       return resolver;
    }

    //statik kaynakların dispatchera gönderilmesine gerek yok
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").//bu pathdeki kaynakları statik olarak sun
                 addResourceLocations("/resources/").//kaynakların yeri
                setCachePeriod(0);//cacheleme için süre verilebilir
    }
}
