package com.example.demo.controller;

import com.example.demo.mq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMsg(@RequestParam String msg) {
        messageProducer.send(msg);
        return "已发送: " + msg;
    }
}
