package com.cloud.service.impl;

import com.cloud.dao.StorageDao;
import com.cloud.domain.Storage;
import com.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceimpl implements StorageService {

    @Autowired
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {

        log.info("** 扣减库存开始");
        // 扣减库存
        storageDao.update(productId, count);
        log.info("** 扣减库存结束");

    }
}
