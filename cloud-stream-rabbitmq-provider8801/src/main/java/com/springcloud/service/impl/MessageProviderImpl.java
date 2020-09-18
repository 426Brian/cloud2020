package com.springcloud.service.impl;

import com.springcloud.service.ImessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;


@EnableBinding(Source.class) // 定义消息推送管道
@Slf4j
public class MessageProviderImpl implements ImessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serialId = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serialId).build());
        log.info("*** serialId: "+ serialId);
        return null;
    }
}
