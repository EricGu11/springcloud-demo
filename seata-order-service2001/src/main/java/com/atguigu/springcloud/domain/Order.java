package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName:Order
 * @Author:lh
 * @description:
 * @Date:2021/8/10 10:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    //订单状态：0：创建中；1：已完结
    private Integer status;
}
