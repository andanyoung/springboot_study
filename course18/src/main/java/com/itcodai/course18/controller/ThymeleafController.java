package com.itcodai.course18.controller;

import com.itcodai.course18.entity.Blogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ThymeleafController
 * @author shengwu ni
 */
@Controller
@Api(value = "博客信息接口")
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/test404")
    @ApiOperation(value = "测试404页面")
    public String test404() {
        return "index";
    }

    @GetMapping("/test500")
    @ApiOperation(value = "测试500页面")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

    @GetMapping("/getBlogger")
    @ApiOperation(value = "获取博主信息")
    public String getBlogger(Model model) {
        Blogger blogger = new Blogger(1L, "倪升武", "123456");
        model.addAttribute("blogger", blogger);
        return "blogger";
    }

    @GetMapping("/getList")
    @ApiOperation(value = "获取博主List")
    public String getList(Model model) {
        Blogger blogger1 = new Blogger(1L, "倪升武", "123456");
        Blogger blogger2 = new Blogger(2L, "公众号", "程序员私房菜");

        List<Blogger> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }
}
