package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @ClassName:MyRule
 * @Author:lh
 * @description:
 * @Date:2021/7/16 16:37
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
