package com.atguigu.springcloud.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class ReceiveMessage {

    @Value("${server.port}")
    private String servePort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println("receive message : " + message.getPayload()+"\t port:"+servePort);
    }
}
