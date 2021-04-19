package com.example.haba;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties()
@SpringBootApplication(scanBasePackages = {"com.example.haba"})
@EntityScan(basePackages = {"com.example.haba"})
public class SpringBootCucumberApplication {

}
