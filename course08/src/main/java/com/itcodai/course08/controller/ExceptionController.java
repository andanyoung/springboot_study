package com.itcodai.course08.controller;

import com.itcodai.course08.entity.JsonResult;
import com.itcodai.course08.exception.BusinessErrorException;
import com.itcodai.course08.exception.BusinessMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping("/null/point/exception")
    public JsonResult testNullPointException() {
        String str = null;
        str.length();
        return new JsonResult();
    }

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {

        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }

    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }
}
