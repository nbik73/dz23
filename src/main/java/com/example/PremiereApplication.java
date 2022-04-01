package com.example;

import com.example.service.PremiereService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class PremiereApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(PremiereApplication.class, args);
        ctx.getBean(PremiereApplication.class);
        ctx.getBean(PremiereService.class).addPremiere("Дон Жуан", "*Описание1*", 12,1000);
        ctx.getBean(PremiereService.class).addPremiere("Жуан Дон", "*Описание2*", 16, 1200);
        ctx.getBean(PremiereService.class).printPremiers();                                    //печать всех премьер
        ctx.getBean(PremiereService.class).printFullDescription("Дон Жуан");   //печать подробно премьеры
        ctx.getBean(PremiereService.class).updatePremiere("Жуан Дон", "Мастер и Маргарита", "*Описание3*", 18, 11100);
        ctx.getBean(PremiereService.class).printPremiers();
        ctx.getBean(PremiereService.class).deletePremiere("Дон Жуан");
        ctx.getBean(PremiereService.class).printPremiers();

    }

}
