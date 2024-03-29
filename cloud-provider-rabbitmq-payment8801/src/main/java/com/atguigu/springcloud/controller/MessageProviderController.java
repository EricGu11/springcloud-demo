package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageProviderController {
    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping(value="/sendMessage")
    public String sendMessage(){
        iMessageProvider.send();
        return "success";
    }
}
