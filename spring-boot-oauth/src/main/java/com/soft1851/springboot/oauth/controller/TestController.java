package com.soft1851.springboot.oauth.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月29日 11:06:00
 * @Version 1.0.0
 */
@RestController
public class TestController {
    @RequestMapping("/index")
    public String simpleIndex(ModelMap map) {
        return "index";
    }
}
