package com.itcodai.course10.service;

import com.itcodai.course10.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    List<User> getAll();

    User getUserByName(String name);

    User getUser(Long id, String name);
}
