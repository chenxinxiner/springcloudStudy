package cn.chenxinzouzou.springcloud_mq_con.config.mqconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.woman";

    @Bean
    Queue manQueue() {
        return new Queue(MAN);
    }
    @Bean
    Queue womanQueue() {
        return new Queue(WOMAN);
    }

    @Bean
    TopicExchange getTopicExchange() {
        return new TopicExchange("topicExchange");
    }

    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(manQueue()).to(getTopicExchange()).with(MAN);
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(womanQueue()).to(getTopicExchange()).with("topic.#");
    }

}
