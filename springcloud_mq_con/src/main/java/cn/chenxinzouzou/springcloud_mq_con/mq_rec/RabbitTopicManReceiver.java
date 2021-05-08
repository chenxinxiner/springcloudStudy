package cn.chenxinzouzou.springcloud_mq_con.mq_rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.man")
public class RabbitTopicManReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者 队列：topic.man 收到消息   : " + testMessage.toString());
    }

}
