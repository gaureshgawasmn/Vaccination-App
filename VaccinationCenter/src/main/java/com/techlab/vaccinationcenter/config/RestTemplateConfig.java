package com.techlab.vaccinationcenter.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Common RestTemplate configuration
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced // this is needed to use the service names instead of the ip address
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
