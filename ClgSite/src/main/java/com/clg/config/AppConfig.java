package com.clg.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfig {
    
    @Value("${Cloudenary.cloud.name}")
    private String cloudName;
    @Value("${Cloudenary.api.key}")
    private String apiKey;
    @Value("${Cloudenary.api.secret}")
    private String apiSecret;
    // @Bean
    // public Cloudinary cloudinary()
    // {
    //     return new Cloudinary(
    //         ObjectUtils.asMap(
    //             "cloud_name" , "dlrtmrmuy",
    //             "api_key" , "279395444683225",
    //             "api_secret" , "-TAX-OlrOnL7Up5wVQ336awekeY"
    
    //         )
    //     );
    // }

    @Bean
    public Cloudinary cloudinary()
    {
        return new Cloudinary(
            ObjectUtils.asMap(
                "cloud_name" , "dlrtmrmuy",
                "api_key" , "279395444683225",
                "api_secret" , "-TAX-OlrOnL7Up5wVQ336awekeY"
            )
        );
    }
}

