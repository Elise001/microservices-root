package com.example.feign.client.fallback;

import com.example.feign.client.AdminFeign;

public class AdminFeignFallback implements AdminFeign {

    @Override
    public String hello(String message) {
        return "admin service fallback";
    }
}
