package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @ClassName:CustomBlockHandler
 * @Author:lh
 * @description:
 * @Date:2021/8/4 13:46
 **/
public class CustomBlockHandler {
    public static CommonResult handleException(BlockException b){
        return new CommonResult(2020, "自定义限流处理。。CustomBlockHandler handleException");
    }

    public static CommonResult handleException2(BlockException b){
        return new CommonResult(2020, "自定义限流处理。。CustomBlockHandler handleException");
    }
}
