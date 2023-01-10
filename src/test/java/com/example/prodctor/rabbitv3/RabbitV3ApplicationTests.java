package com.example.prodctor.rabbitv3;

import com.example.prodctor.rabbitv3.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitV3ApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.addOrder("1","22",20);
    }

}
