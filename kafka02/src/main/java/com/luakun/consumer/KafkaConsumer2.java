package com.luakun.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luakun.pojo.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luakun
 * @Date: 2021/03/26/19:50
 * @Description:
 */

@Component
public class KafkaConsumer2 {
    @Autowired
    private ObjectMapper objectMapper;
    @KafkaListener(topics = {"luakun"})
    public void listen(ConsumerRecord<String,String> record){
        String value = record.value();
        System.out.println("=======================2222222222===============================");
        System.out.println("接受的消息为:" +  objectMapper.readValue(value, Message.class).getMsg());
    }
}
