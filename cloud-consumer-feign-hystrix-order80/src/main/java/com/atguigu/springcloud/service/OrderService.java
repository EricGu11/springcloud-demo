package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName:OrderService
 * @Author:lh
 * @description:
 * @Date:2021/7/20 13:56
 **/
@Service
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = OrderServiceImpl.class)
public interface OrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
