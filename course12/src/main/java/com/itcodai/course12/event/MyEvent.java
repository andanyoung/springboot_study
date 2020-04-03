package com.itcodai.course12.event;

import com.itcodai.course12.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author shengwu ni
 * @date 2018/07/05
 */
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
