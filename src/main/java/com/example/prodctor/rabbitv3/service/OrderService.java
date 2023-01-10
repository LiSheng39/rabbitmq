package com.example.prodctor.rabbitv3.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Description:
 * @Author:
 * @Date: Created in  2023/1/7
 */
@Service
public class OrderService {
    @Autowired(required = false)
    private RabbitTemplate rabbitTemplate;

    public void addOrder(String userId,String produiId,int num){

        String orderId = UUID.randomUUID().toString();
        System.out.println("ggg：" + orderId);

        String xechange = "fanout_order_exchange";

        String routingKey = "";

        rabbitTemplate.convertAndSend(xechange,routingKey,orderId);

    }

}
