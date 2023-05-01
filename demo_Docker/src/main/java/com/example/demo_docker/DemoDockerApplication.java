package com.example.demo_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoDockerApplication {

    @GetMapping("/")
    public String vlad() {
        return "***!HAPPY NEW YEAR!***";
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoDockerApplication.class, args);
    }

}
