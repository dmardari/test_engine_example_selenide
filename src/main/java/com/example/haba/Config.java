package com.example.haba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "configuration")
public class Config {

    @Value("${url}")
    public String url;

    @Value("${browser}")
    public String browser;
}
