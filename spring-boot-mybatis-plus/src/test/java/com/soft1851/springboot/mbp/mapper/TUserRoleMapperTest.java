package com.soft1851.springboot.mbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest
@WebAppConfiguration(value = "TUserRoleMapper.xml")
class TUserRoleMapperTest {
    @Resource
    private TUserRoleMapper mapper;

    @Test
    void getUserById() {
        System.out.println(mapper.getUserById("1"));
    }
}