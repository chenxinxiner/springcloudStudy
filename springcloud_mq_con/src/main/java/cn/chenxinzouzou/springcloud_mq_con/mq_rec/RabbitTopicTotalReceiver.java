package cn.chenxinzouzou.springcloud_mq_con.mq_rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class RabbitTopicTotalReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者 队列：topic.woman 收到消息   : " + testMessage.toString());
    }

}
