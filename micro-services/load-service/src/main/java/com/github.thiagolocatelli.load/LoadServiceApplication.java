package com.github.thiagolocatelli.load;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadServiceApplication.class, args);
    }

}
