package com.itcodai.course11.service.impl;

import com.itcodai.course11.dao.UserMapper;
import com.itcodai.course11.entity.User;
import com.itcodai.course11.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public void isertUser(User user) {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void isertUser2(User user) throws Exception {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new SQLException("数据库异常");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void isertUser3(User user) {
        try {
            // 插入用户信息
            userMapper.insertUser(user);
            // 手动抛出异常
            throw new SQLException("数据库异常");
        } catch (Exception e) {
            // 异常处理逻辑
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void isertUser4(User user) {
        // 插入用户信息
        userMapper.insertUser(user);
    }
}
