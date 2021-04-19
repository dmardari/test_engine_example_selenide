package com.example.haba;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.example.haba"})
@EntityScan(basePackages = {"com.example.haba"})
public class SpringBootCucumberApplication {

}
