package com.itcodai.course12.service;

import com.itcodai.course12.entity.User;
import com.itcodai.course12.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserService
 * @author shengwu ni
 */
@Service
public class UserService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布事件
     * @return
     */
    public User getUser2() {
        User user = new User(1L, "倪升武", "123456");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }

    /**
     * 获取用户信息
     * @return
     */
    public User getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User(1L, "倪升武", "123456");
    }
}
