package com.testRabbitQm.rabbitqm.rabbitqm;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MqConfiguration.QUEUE)
    public void listener(CustomMessage message){
        System.out.println(message);
    }

}
