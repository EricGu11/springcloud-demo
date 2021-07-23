package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:GatewayConfig
 * @Author:lh
 * @description:
 * @Date:2021/7/21 15:13
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocator build = builder.routes().route("path_rote_atguigu", r->{
          return  r.path("/guonei").uri("http://news.baidu.com/guonei");
        }).build();
        return build;
    }
}
