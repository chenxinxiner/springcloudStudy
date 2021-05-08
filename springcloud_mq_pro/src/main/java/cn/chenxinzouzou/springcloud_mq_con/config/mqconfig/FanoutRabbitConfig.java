package cn.chenxinzouzou.springcloud_mq_con.config.mqconfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    @Bean
    Queue queueFanoutA() {
        return new Queue("fanout.A");
    }
    @Bean
    Queue queueFanoutB() {
        return new Queue("fanout.B");
    }
    @Bean
    Queue queueFanoutC() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange getFanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutExchangeMessage() {
        return BindingBuilder.bind(queueFanoutA()).to(getFanoutExchange());
    }
    @Bean
    Binding bindingFanoutExchangeMessageB() {
        return BindingBuilder.bind(queueFanoutB()).to(getFanoutExchange());
    }
    @Bean
    Binding bindingFanoutExchangeMessageC() {
        return BindingBuilder.bind(queueFanoutC()).to(getFanoutExchange());
    }

}
