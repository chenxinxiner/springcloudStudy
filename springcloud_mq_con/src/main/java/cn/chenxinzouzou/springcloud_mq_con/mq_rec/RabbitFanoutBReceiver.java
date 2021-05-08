package cn.chenxinzouzou.springcloud_mq_con.mq_rec;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.B")
public class RabbitFanoutBReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("fanout.B消费者收到消息   : " + testMessage.toString());
    }

}
