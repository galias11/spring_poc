package com.bm.test.bm_test.config;

import com.bm.test.bm_test.model.dto.VideoForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public VideoForm videoForm() {
        return new VideoForm();
    }
}
