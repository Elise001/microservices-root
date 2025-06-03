package com.example.gate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource; // 传统的servlet模型，基于tomcat模型，使用Filter过滤器
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource; // 基于spring webflux模型，使用WebFilter过滤器
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 全局跨域配置
 */
@Configuration
public class CorsGlobalConfig {
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*"); // 允许任何域名
        config.addAllowedHeader("*"); // 允许任何头
        config.addAllowedMethod("*"); // 允许任何方法
        config.setAllowCredentials(true); // 允许发送Cookie
        // 创建响应式 CORS 配置源，使用 PathPatternParser 支持路径模式匹配
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config); //  匹配所有路径
        return new CorsWebFilter(source);
    }
}
