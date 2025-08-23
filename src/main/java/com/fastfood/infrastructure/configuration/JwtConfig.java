package com.fastfood.infrastructure.configuration;

import com.fastfood.infrastructure.configuration.seguridad.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtConfig {
    // Esta clase asegura que JwtProperties se cree como bean
}