package com.itcodai.course18.controller;

import com.itcodai.course18.entity.JsonResult;
import com.itcodai.course18.entity.User;
import com.itcodai.course18.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 * @author shengwu ni
 */
@RestController
@Api(value = "用户信息接口")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") Long id) {
        User user = userService.getUser(id);
        return new JsonResult<>(user);
    }

    @GetMapping("/getUserByName/{name}")
    @ApiOperation(value = "根据用户名获取用户信息")
    public JsonResult<User> getUserByName(@PathVariable String name) {
        User user = userService.getUserByName(name);
        return new JsonResult<>(user);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有用户信息")
    public JsonResult<List<User>> getAll() {
        List<User> list = userService.getAll();
        return new JsonResult<>(list);
    }

    @ApiOperation(value = "测试jackson对null的处理")
    @GetMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>(3);

        User user = new User(1L, "倪升武", null);
        map.put("作者信息", user);
        map.put("博客地址", "http://www.itcodai.com");
        map.put("CSDN地址", null);
        map.put("微信公众号", "程序员私房菜");
        return map;
    }

    @ApiOperation(value = "测试全局异常处理的处理")
    @GetMapping("/exception")
    public JsonResult testException() {
        // 抛出异常，全局异常会捕获，然后做处理
        int i = 1 / 0;
        return new JsonResult();
    }
}
