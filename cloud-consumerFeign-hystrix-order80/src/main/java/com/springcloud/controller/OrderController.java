package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.ConsumerHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class OrderController {

    @Autowired
    private ConsumerHystrixService consumerHystrixService;

    @RequestMapping("/consumer/hystrix/ok/{id}")
    public String paymenthystrixOk(@PathVariable("id") Long id) {
        return consumerHystrixService.paymentInfo_ok(id);
    }

    @RequestMapping("/consumer/hystrix/timeout/{id}")
    public String paymentFeignTimeout(@PathVariable("id") Long id){
       return consumerHystrixService.paymentInfo_timeout(id);
    }
}
