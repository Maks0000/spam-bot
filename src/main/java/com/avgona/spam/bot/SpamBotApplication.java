package com.avgona.spam.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpamBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpamBotApplication.class, args);
    }
}
