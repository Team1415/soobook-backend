package com.team1415.soobookbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoobookBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoobookBackendApplication.class, args);
    }
}
