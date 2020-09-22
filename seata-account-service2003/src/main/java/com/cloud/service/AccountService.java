package com.cloud.service;

import com.cloud.domain.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    CommonResult decrease(@RequestParam("money") BigDecimal money, @RequestParam("userId") Long userId);
}
