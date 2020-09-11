package com.springcloud.service;


import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-payment-hystrix-service")
public interface ConsumerHystrixService {

    @RequestMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Long id);

}
