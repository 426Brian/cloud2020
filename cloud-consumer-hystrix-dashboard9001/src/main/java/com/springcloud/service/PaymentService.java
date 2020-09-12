package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_ok(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_ok, id: " + id;
    }


    @HystrixCommand(fallbackMethod = "fallbackHandler",
            commandProperties =
                    {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),})
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_timeout, id: " + id + " 耗时 " + timeNumber + " 秒";
    }

    public String fallbackHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " fallbackHandler, id: " + id + "  服务降级处理方法";
    }
}
