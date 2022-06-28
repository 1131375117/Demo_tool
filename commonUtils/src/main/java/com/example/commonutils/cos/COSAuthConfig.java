package com.example.commonutils.cos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuhua
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "cos")
public class COSAuthConfig {
    private String secretId;
    private String secretKey;
    private String region;
}
