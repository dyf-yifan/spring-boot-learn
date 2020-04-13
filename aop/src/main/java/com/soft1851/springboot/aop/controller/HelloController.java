package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月12日 10:28:00
 * @Version 1.0.0
 */
@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class HelloController {
    /**
     * 采用自定的WebLog日志注解，记录调用的接口方法名，是否需要持久化
     * @param name
     * @param arg2
     * @return
     */
    @RequestMapping(value = "hello")
    @ControllerWebLog(name = "getHello",isSaved = true)
    public String getHello(String name, int arg2, HttpServletRequest request) {
        log.info("控制层获得参数：" + name);
        log.info("控制层获得参数：" + arg2);
        log.info("token:"+request);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello spring boot" + name + request;
    }
}