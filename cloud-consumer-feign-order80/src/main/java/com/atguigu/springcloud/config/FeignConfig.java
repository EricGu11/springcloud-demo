package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:FeignConfig
 * @Author:lh
 * @description:
 * @Date:2021/7/20 9:04
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level logger(){
        return Logger.Level.FULL;
    }
}
