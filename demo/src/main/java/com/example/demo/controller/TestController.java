package com.example.demo.controller;

import com.example.demo.mq.producer.DemoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DemoProducer demoProducer;

    @GetMapping("/send")
    public String sendMsg() {
        demoProducer.send("test");
        return "已发送";
    }
}
