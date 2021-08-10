package com.atguigu.springcloud.service;

/**
 * @ClassName:StorageService
 * @Author:lh
 * @description:
 * @Date:2021/8/10 11:06
 **/
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
