package com.hwy.study01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 可以使用 @Pointcut 指定切点
 */
@Aspect
@Order(-10)
@Component
public class LogAspect {

    @Pointcut("execution(* com.hwy.study01.controller.OrderController.*(..))")
    public void pcut1(){}


    @Pointcut("execution(* com.hwy.study01.controller.UserController.*(..))")
    public void pcut2(){}

    @Before("@annotation(logAnnotation)")
    public void beforePrintLog(JoinPoint joinPoint, LogAnnotation logAnnotation){
        ServletRequestAttributes attributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("================ before =================");
        System.out.println("before");
        System.out.println(joinPoint);
        System.out.println(logAnnotation.value());
        System.out.println("================ before =================");
    }


    @Before("@annotation(logAnnotation)")
    public void afterPrintLog(JoinPoint joinPoint, LogAnnotation logAnnotation){
        System.out.println("================ after =================");
        System.out.println(joinPoint);
        System.out.println(logAnnotation.value());
        System.out.println("================ after =================");
    }

    @Before("pcut1() || pcut2()")
    public void beforeController(JoinPoint point) {
        System.out.println("================ pcut after =================");
        System.out.println(point.getSignature().getDeclaringType());
        System.out.println("================ pcut after =================");
    }
}
