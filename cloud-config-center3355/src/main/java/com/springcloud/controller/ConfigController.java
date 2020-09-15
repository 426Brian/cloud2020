package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${config.info}")
    protected String configInfo;

    @GetMapping("/configInfo")
    protected String getConfigInfo(){
        return configInfo;
    }
}
