package com.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class FallbackService implements ConsumerHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "***  com.springcloud.service.FallbackService#paymentInfo_ok *** ";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "***  com.springcloud.service.FallbackService#paymentInfo_timeout *** ";
    }
}
