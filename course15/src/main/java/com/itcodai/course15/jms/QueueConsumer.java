package com.itcodai.course15.jms;

import com.itcodai.course15.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 * @author shengwu ni
 */
@Service
public class QueueConsumer {

    /**
     * 接收点对点消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg) {
        System.out.println("收到的消息为：" + msg);
    }
}
