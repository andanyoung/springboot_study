package com.itcodai.course16.service;

import com.itcodai.course16.dao.UserDao;
import com.itcodai.course16.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class UserService {

    @Resource
    private UserDao userDao;


    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }
}
