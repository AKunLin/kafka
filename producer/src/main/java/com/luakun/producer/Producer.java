package com.luakun.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luakun.pojo.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/26/20:02
 * @Description: 生产者
 */

@Component
public class Producer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    public void send() throws Exception {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        //设置主题
        kafkaTemplate.send("luakun", objectMapper.writeValueAsString(message));
    }

}
