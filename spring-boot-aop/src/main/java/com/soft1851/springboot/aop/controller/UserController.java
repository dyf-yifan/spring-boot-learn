package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月13日 15:25:00
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class UserController {
    /**
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(String name) {
        log.info("hello()方法无需授权，也无需认证");
        return "hell方法访问成功";
    }

    /**
     * 需要登陆校验，此时该方法需要加注解，但是不需要传角色
     *
     * @param name
     * @return
     */
    @GetMapping("user")
    @AuthToken
    public String user(String name) {
        log.info("user()方法需要认证，当前用户名：" + name);
        return "user()方法访问成功";
    }

    /**
     * 需要鉴权，此时该方法需要加注解，需要传角色
     * 角色可以传多个
     * 如果需要更复杂的逻辑需要，建议使用Spring Security,Apache Shiro等安全框架
     *
     * @param name
     * @return
     */
    @GetMapping("admin")
    @AuthToken(role_name = {"admin", "Admin"})
    public String admin(String name) {
        log.info("admin()方法需要鉴权，当前用户名：" + name);
        return "admin()方法访问成功";
    }
}
