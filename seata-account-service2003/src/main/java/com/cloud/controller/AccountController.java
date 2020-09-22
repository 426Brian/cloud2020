package com.cloud.controller;

import com.cloud.domain.CommonResult;
import com.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult create(@RequestParam("money") BigDecimal money, @RequestParam("userId") Long userId){
        accountService.decrease(money, userId);
        return new CommonResult(200, "订单创建成功");
    }
}
