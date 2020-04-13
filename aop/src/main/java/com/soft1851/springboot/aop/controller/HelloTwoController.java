package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HelloTwoController
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月12日 12:01:00
 * @Version 1.0.0
 */
@RequestMapping(value = "/api/")
@RestController
public class HelloTwoController {
    @ControllerWebLog(name = "getHello",isSaved = true)
    @RequestMapping(value = "hello")
        public String hello(String name, HttpServletRequest request) {
            if (request.getHeader("token").equals("2655632")) {
                return "hello" + name;
            } else {
                return "world";
            }
        }
    }

