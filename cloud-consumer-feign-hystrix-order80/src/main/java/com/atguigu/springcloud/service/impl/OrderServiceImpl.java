package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName:OrderServiceImpl
 * @Author:lh
 * @description:
 * @Date:2021/7/21 9:30
 **/
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

}
