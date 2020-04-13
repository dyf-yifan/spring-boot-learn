package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthTokenAspect
 * @Description TODO
 * @Author 丁怡凡
 * @Date 2020年04月13日 15:40:00
 * @Version 1.0.0
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    /**
     * 配置加上自定义注解的方法为切点
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {

    }

    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //取得注解中的role-name的值
        String[] roleNames = authToken.role_name();
        if (roleNames.length <= 1) {
            //只需要认证（登录）
            val id = request.getHeader("id");
            //如果id为空，可以调用目标方法
            if (id != null) {
                return pjp.proceed();
            }
            return "请先登录";
        } else {
            //验证身份
            String role = request.getHeader("role");
            //遍历roleName数组，匹配role
            for (String roleName : roleNames) {
                if (roleName.equals(role)) {
                    //身份匹配成功，调用目标方法
                    return pjp.proceed();
                }
            }
            return "权限不足，无法访问";
        }
    }
}