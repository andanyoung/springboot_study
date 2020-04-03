package com.itcodai.course15.jms;

import com.itcodai.course15.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Topic消息消费者
 * @author shengwu ni
 */
@Service
public class TopicConsumer2 {

    /**
     * 接收订阅消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg(String msg) {
        System.out.println("收到的消息为：" + msg);
    }
}
