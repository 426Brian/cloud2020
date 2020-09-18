package com.springcloud.controller;

import com.springcloud.service.ImessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StreamSendController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ImessageProvider messageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage() {
        messageProvider.send();
        return "serverPort : " + serverPort + "  serilaId  *** " + UUID.randomUUID().toString();
    }
}
