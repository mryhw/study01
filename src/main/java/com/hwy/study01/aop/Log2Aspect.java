package com.hwy.study01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Order(-1)
@Component
public class Log2Aspect {

    @Pointcut("execution(* com.hwy.study01.controller.*.*(..))")
    public void pcut1(){}

    @Before("LogAspect.pcut1()")
    public void beforeController(JoinPoint point) {
        System.out.println("================ pcut after =================");
        System.out.println(point.getSignature().getDeclaringType());
        System.out.println("================ pcut after =================");
    }

}
