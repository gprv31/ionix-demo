package com.example.ionix.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ionix.encryption-configuration")
@Getter
@Setter
public class EncryptionValuesProperties {
  private String secret;
}
