package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "defaultFallbackHandler")
public class OrderController {

    @Autowired
    private ConsumerHystrixService consumerHystrixService;

    @RequestMapping("/consumer/hystrix/ok/{id}")
    public String paymenthystrixOk(@PathVariable("id") Integer id) {
        return consumerHystrixService.paymentInfo_ok(id);
    }

    @RequestMapping("/consumer/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "fallbackHandler",
            commandProperties =
                    {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})*/
    @HystrixCommand
    public String paymentFeignTimeout(@PathVariable("id") Integer id){
       return consumerHystrixService.paymentInfo_timeout(id);
    }

    public String fallbackHandler(@PathVariable("id") Integer id){
        return "线程池： " + Thread.currentThread().getName() + " fallbackHandler, id: " + id + "  服务降级处理方法";
    }

    public String defaultFallbackHandler(){
        return "线程池： " + Thread.currentThread().getName() + " 全局默认服务降级处理方法";
    }
}
