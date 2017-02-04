package com.wsf.config;

import com.wsf.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YSD on 2017/1/25.
 */
@Configuration
public class Config {

    @Bean
    MyFilter restTemplate() {
        return new MyFilter();
    }
}
