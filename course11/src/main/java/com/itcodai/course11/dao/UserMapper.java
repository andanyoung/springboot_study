package com.itcodai.course11.dao;

import com.itcodai.course11.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert("insert into user (user_name, password) values (#{username}, #{password})")
    Integer insertUser(User user);
}
