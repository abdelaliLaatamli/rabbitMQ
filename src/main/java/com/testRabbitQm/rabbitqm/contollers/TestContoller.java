package com.testRabbitQm.rabbitqm.contollers;

import com.testRabbitQm.rabbitqm.rabbitqm.CustomMessage;
import com.testRabbitQm.rabbitqm.rabbitqm.MqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestContoller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public String test(){
        CustomMessage message = CustomMessage.builder()
                .messageId(UUID.randomUUID().toString())
                .message("hhhhh message")
                .messageDate( new Date())
                .build();
        rabbitTemplate.convertAndSend(MqConfiguration.MESSAGE_EXCHANGE , MqConfiguration.ROUTING_KEY , message);

        return "message published";
    }

}
