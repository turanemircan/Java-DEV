package com.tpe;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Java tabanlı web uyg. web.xml dosyası ile config edilir.
//web.xml yerine bu claası kullanacağız.

//AbstractAnnot... : classının metodlarını override ederek DispatcherServletın config
// ve başlatılmasını kolaylaştırır.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*dispatcher:
              Servlet WebAppContext-->controllers-viewresolver-handlermapping
              Root WebAppContext-->dataya erişim:services-repos
    */

    @Override
    protected Class<?>[] getRootConfigClasses() {//dataya erişim(hibernate)
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//controllers-viewresolver-handlermapping
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
