package com.techlab.vaccinationcenter.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Service discovery naming configuration through application.properties/application.yml
 */
@Component
@ConfigurationProperties(prefix = "service.discovery.names")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfoConfig {

    private String citizenService;
}
