package com.cloud.service.impl;

import com.cloud.dao.OrderDao;
import com.cloud.domain.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "my_test_tx_group", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("**  新建订单");
        // 1. 新建订单
        orderDao.create(order);

        log.info("** 订单微服务开始调用库存， 做扣减");
        // 2. 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("** 订单微服务开始调用库存， 做扣减end");

        log.info("** 订单微服务开始调用账户， 做扣减");
        // 3. 扣减账户
        accountService.decrease(order.getMoney(), order.getUserId());
        log.info("** 订单微服务开始调用账户， 做扣减end");

        log.info("**  修改订单状态开始");
        // 4. 修改状态
        orderDao.update(order.getUserId(), 0);
        log.info("**  修改订单状态结束");

        log.info("*** 下订单结束");
    }

}
