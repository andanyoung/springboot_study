package com.itcodai.course05.controller;

import com.itcodai.course05.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
public class TestController {

    /**
     * 测试@RequestMapping
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    /**
     * 测试@Pathvariable注解，一个参数
     * @param id
     * @return
     */
    @GetMapping("/user/{idd}")
    public String testPathVariable(@PathVariable(value = "idd") Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    /**
     * 测试@Pathvariable注解，多个参数
     * @param id
     * @return
     */
    @GetMapping("/user/{idd}/{name}")
    public String testPathVariable(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        System.out.println("获取到的id为：" + id);
        System.out.println("获取到的name为：" + name);
        return "success";
    }

    /**
     * 测试@RequestParam注解
     * @param id
     * @return
     */
    @GetMapping("/user")
    public String testRequestParam(@RequestParam Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    /**
     * 测试@RequestBody注解
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String testRequestBody(@RequestBody User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

    /**
     * 测试@RequestParam多个参数（表单提交）
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/form1")
    public String testForm(@RequestParam String username, @RequestParam String password) {
        System.out.println("获取到的username为：" + username);
        System.out.println("获取到的password为：" + password);
        return "success";
    }

    /**
     * 测试表单提交，接收实体前不能加@RequestBody注解
     * @param user
     * @return
     */
    @PostMapping("/form2")
    public String testForm(User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

}
