package zool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    /*配置文件上传1*/
    /*@Bean
    public MultipartResolver multipartResolver (){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5000000);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }*/

    /*配置文件上传2*/
    @Bean
    public MultipartResolver multipartResolver(){
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        return multipartResolver;
    }

}
