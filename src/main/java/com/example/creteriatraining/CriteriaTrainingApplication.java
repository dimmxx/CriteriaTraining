package com.example.creteriatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CriteriaTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriteriaTrainingApplication.class, args);

//        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
