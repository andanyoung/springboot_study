package com.itcodai.course15.controller;

import com.itcodai.course15.jms.MsgProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * ActiveMQ controller
 * @author shengwu ni
 */
@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);

    @Resource
    private MsgProducer producer;
    @Resource
    private Destination topic;
    @Resource
    private Destination queue;

    @GetMapping("/send/queue")
    public String sendQueueMessage() {

        logger.info("===开始发送点对点消息===");
//        Destination destination = new ActiveMQQueue(ActiveMqConfig.QUEUE_NAME);
        producer.sendMessage(queue, "Queue: hello activemq!");
        return "success";
    }

    @GetMapping("/send/topic")
    public String sendTopicMessage() {

        logger.info("===开始发送订阅消息===");
//        Destination destination = new ActiveMQTopic(ActiveMqConfig.TOPIC_NAME);
        producer.sendMessage(topic, "Topic: hello activemq!");
        return "success";
    }
}
