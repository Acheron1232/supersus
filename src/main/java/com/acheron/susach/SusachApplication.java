package com.acheron.susach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SusachApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SusachApplication.class, args);
        ValueGenerator bean = run.getBean(ValueGenerator.class);
        EntityRepo bean1 = run.getBean(EntityRepo.class);
        bean1.findAll().forEach(bean::generate);
    }

}
