package com.example.demo;

import com.example.demo.service.FileStorageProperties;
import com.example.demo.service.FiltroAdministrador;
import com.example.demo.service.FiltroCliente;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.yuequan.jpa.soft.delete.repository.EnableJpaSoftDeleteRepositories;

@EnableConfigurationProperties({
    FileStorageProperties.class
})

/*
 
  @author Alcídia Cristina
 */

@EnableJpaSoftDeleteRepositories
@SpringBootApplication
public class DemoApplication {
    @Bean
    public FilterRegistrationBean filtroJwtAdministrador(){
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new FiltroAdministrador());
        fr.addUrlPatterns("/admin/*");
        return fr;
    }
    
    @Bean
    public FilterRegistrationBean filtroJwtCliente(){
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new FiltroCliente());
        fr.addUrlPatterns("/auth/*");
        return fr;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
        
    @Bean
    public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
     
    mailSender.setUsername("iporafarma@gmail.com");
    mailSender.setPassword("iporafarma12");
     
    
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
     
    return mailSender;
}
}