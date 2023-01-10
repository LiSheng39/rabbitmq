package com.example.prodctor.rabbitv3.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author:
 * @Date: Created in  2023/1/7
 */
@Configuration
public class RabbitMqConfiguration {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_order_exchange");
    }
    @Bean
    public Queue smsQueue(){
        return new Queue("sms.fanout.queue");
    }
    @Bean
    public Queue emailQueue(){
        return new Queue("email.fanout.queue");
    }
    @Bean
    public Queue duanxinQueue(){
        return new Queue("duanxin.fanout.queue");
    }
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding duanxinBinding(){
        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
    }

}
