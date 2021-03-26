package com.luakun;

import com.luakun.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动类
 */
@SpringBootApplication
public class KafkaClientApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(KafkaClientApplicaton.class, args);
    }

    @RestController
    class TestController {
        @Autowired
        private Producer producer;

        /**
         * @return
         * @throws Exception
         */
        @GetMapping("/send")
        public String sendM1() throws Exception {
            producer.send();
            return "ok";
        }
    }
}