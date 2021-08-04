package com.digitalinnovation.quickStarting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${db:NONE}")
    private String db;

    @GetMapping("/var")
    public String environmentVar(){
        return db;
    }

    @GetMapping("/")
    public String getAppMessage(){
        return appMessage;
    }



}
