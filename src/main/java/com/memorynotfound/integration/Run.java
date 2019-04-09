package com.memorynotfound.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Run implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(Run.class);

    @Autowired
    private OrderSender orderSender;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring JMS ActiveMQ Validate Messages using @Valid Example");

        orderSender.sendQueue(new Order("ee", "lilly", new BigDecimal(101), "re"));
        orderSender.sendQueue(new Order("me", "lukas", new BigDecimal(200), "be"));
        orderSender.sendQueue(new Order("me", "underwood", new BigDecimal(173), "2"));
        orderSender.sendQueue(new Order("me", "nancy", new BigDecimal(2), "33"));

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
