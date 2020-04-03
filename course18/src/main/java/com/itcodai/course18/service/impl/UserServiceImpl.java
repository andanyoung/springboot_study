package com.itcodai.course18.service.impl;

import com.itcodai.course18.dao.UserMapper;
import com.itcodai.course18.entity.User;
import com.itcodai.course18.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * userService
 * @author shengwu ni
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUser(Long id, String name) {
        return userMapper.getUserByIdAndName(id, name);
    }
}
