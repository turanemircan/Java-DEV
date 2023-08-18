package com.tpe;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Java tabanlı web uyg. web.xml dosyası ile config edilir.
//web.xml yerine bu claası kullanacağız.

//AbstractAnnot... : classının metodlarını override ederek DispatcherServletın config
// ve başlatılmasını kolaylaştırır.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*dispatcher:
              Servlet WebAppContext-->controller-viewresolver-handlermapping
              Root WebAppContext-->dataya erişim:services-repos
    */

    @Override
    protected Class<?>[] getRootConfigClasses() {//dataya erişim(hibernate-jdbc)
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//controllers-viewresolver-handlermapping(SpringMVC config)
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override//hangi url ile gelen istekler servlet tarafından karşılanacak
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }


}
