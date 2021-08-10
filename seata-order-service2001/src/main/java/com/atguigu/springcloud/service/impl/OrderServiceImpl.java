package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:OrderServiceImpl
 * @Author:lh
 * @description:
 * @Date:2021/8/10 10:43
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        /**
         * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
         */
        log.info("----->开始新建订单");
        orderDao.create(order);
        log.info("----->订单新建成功");

        log.info("----->开始扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->扣减库存成功");

        log.info("----->开始扣减账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->账户余额扣减成功");

        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");
    }
}
