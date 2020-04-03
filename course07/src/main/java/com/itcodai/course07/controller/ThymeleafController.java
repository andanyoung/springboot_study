package com.itcodai.course07.controller;

import com.itcodai.course07.entity.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/test404")
    public String test404() {
        return "index";
    }

    @GetMapping("/test500")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

    @GetMapping("/getBlogger")
    public String getBlogger(Model model) {
        Blogger blogger = new Blogger(1L, "倪升武", "123456");
        model.addAttribute("blogger", blogger);
        return "blogger";
    }

    @GetMapping("/getList")
    public String getList(Model model) {
        Blogger blogger1 = new Blogger(1L, "倪升武", "123456");
        Blogger blogger2 = new Blogger(2L, "达人课", "123456");

        List<Blogger> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }
}
