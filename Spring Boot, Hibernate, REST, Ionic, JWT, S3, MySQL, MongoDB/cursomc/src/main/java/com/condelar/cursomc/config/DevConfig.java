package com.condelar.cursomc.config;

import com.condelar.cursomc.services.DBService;
import com.condelar.cursomc.services.EmailService;
import com.condelar.cursomc.services.MockEmailservice;
import com.condelar.cursomc.services.SmtpEmailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String stategy;

    @Bean
    public boolean instanciateDatabse() throws ParseException {
        if (!"create".equals(stategy))
            return false;
        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailservice();
    }
}
