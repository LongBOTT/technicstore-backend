package com.example.technicstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Áp dụng cho tất cả các endpoint
                .allowedOrigins("http://127.0.0.1:5173", "http://localhost:5173", "http://192.168.93.42:5173")  // Cho phép origin cụ thể
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Các phương thức HTTP được phép
                .allowedHeaders("*")  // Cho phép tất cả các header
                .allowCredentials(true);  // Nếu bạn cần cho phép gửi cookie
    }
}
