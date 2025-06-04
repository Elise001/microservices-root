package com.example.demo.controller;

import com.example.demo.mq.producer.DemoProducer;
import com.example.feign.client.AdminFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final AdminFeign adminFeign;
    private final DemoProducer demoProducer;

    @Autowired
    public TestController(AdminFeign adminFeign, DemoProducer demoProducer) {
        this.adminFeign = adminFeign;
        this.demoProducer = demoProducer;
    }

    @GetMapping("/send")
    public String sendMsg() {
        demoProducer.send("test");
        return "已发送";
    }

    @GetMapping("/userDemo/{message}")
    public String userDemo(@PathVariable("message") String message) {
        return adminFeign.hello(message);
    }
}
