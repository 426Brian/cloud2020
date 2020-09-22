package com.cloud.service.impl;

import com.cloud.dao.AccountDao;
import com.cloud.domain.CommonResult;
import com.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceimpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public CommonResult decrease(BigDecimal money, Long userId) {
        //  修改账户
        log.info("**  修改账户开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.update(money, userId);
        log.info("*** 下订单结束");
        return null;
    }
}
