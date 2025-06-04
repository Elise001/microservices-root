package com.example.feign.client;

import com.example.feign.client.fallback.AdminFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admin",contextId = "adminClient", fallback = AdminFeignFallback.class)
public interface AdminFeign {

    @GetMapping("/demo/hello/{message}")
    String hello(@PathVariable("message") String message);
}
