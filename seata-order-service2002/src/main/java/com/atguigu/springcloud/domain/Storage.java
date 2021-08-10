package com.atguigu.springcloud.domain;

import lombok.Data;

/**
 * @ClassName:Storage
 * @Author:lh
 * @description:
 * @Date:2021/8/10 10:57
 **/
@Data
public class Storage {
    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;

}
