package com.soft1851.springboot.jwt.interceptor;

import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName JwtInterceptor
 * @Description Jwt拦截器
 * @Author 丁怡凡
 * @Date 2020年04月15日
 * @Version 1.0.0
 */
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            log.info("## token= {}", token);
        }
        {
            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))) {
                log.info("### 用户权限不足 ###");
                throw new JwtException("用户权限不足", ResultCode.PERMISSION_NO_ACCESS);
            } else {
                if (JwtTokenUtil.isExpiration(token)) {
                    log.info("### token已失效 ###");
                    throw new JwtException("token已失效", ResultCode.USER_TOKEN_EXPIRES);
                } else {
                    //通过认证，放行到controller层
                    return true;
                }
            }
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
