package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment) {
        int result = paymentService.create(payment);
        log.info("***** 插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功, serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        log.info("***** 查找结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查找成功, serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录, 查询id == " + id, null);
        }

    }

    @RequestMapping("/payment/test")
    public String test(){
        System.out.println("test ========= PaymentController");
        return "hello ";
    }

}
