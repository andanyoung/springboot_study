package com.itcodai.course11.controller;

import com.itcodai.course11.entity.User;
import com.itcodai.course11.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    /**
     * 正常测试
     * @param user
     * @return
     */
    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) throws Exception {
        if (null != user) {
            userService.isertUser(user);
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 测试异常并没有被捕获到
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser2")
    public String addUser2(@RequestBody User user) throws Exception {
        if (null != user) {
            userService.isertUser2(user);
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 测试异常被吃掉
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/adduser3")
    public String addUser3(@RequestBody User user) {
        if (null != user) {
            userService.isertUser3(user);
            return "success";
        } else {
            return "false";
        }
    }

}
