package com.example.gate.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 熔断降级回调接口
 */
@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @RequestMapping("/demo")
    public Mono<String> fallbackDemo() {
        return Mono.just("Demo 服务暂时不可用，请稍后再试。");
    }

    @RequestMapping("/admin")
    public Mono<String> fallbackAdmin() {
        return Mono.just("Admin 服务暂时不可用，请稍后再试。");
    }
}

