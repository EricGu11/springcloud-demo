package com.atguigu.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:FlowLimitController
 * @Author:lh
 * @description:
 * @Date:2021/7/29 10:38
 **/
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        System.out.println(DateUtil.now()+"---> testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
       return "------testB";
    }


    @GetMapping("/testD")
    public String testD()
    {
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //log.info("testD 测试RT");

        log.info("testD 测试异常比例");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String test_hotkey(@RequestParam(value = "p1", required = false)String p1,
                              @RequestParam(value = "p2", required = false)String p2){
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "------deal_testHotKey,o(╥﹏╥)o, " + e.getClass();
    }
}
