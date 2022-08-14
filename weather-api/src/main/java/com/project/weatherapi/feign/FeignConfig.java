package com.project.weatherapi.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.weatherapi.decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new CustomErrorDecoder(objectMapper);
    }
}
