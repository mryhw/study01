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

    /**
     * 例： execution (* com.sample.service..*. *(..))
     * 整个表达式可以分为五个部分：
     * 1、execution():：表达式主体。
     * 2、第一个*号：表示返回类型， *号表示所有的类型。
     * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service包、子孙包下所有类的方法。
     * 4、第二个*号：表示类名，*号表示所有的类。
     * 5、*(..)：最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
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


    /**
     * 切点为 注解的方式
     * @param joinPoint
     * @param logAnnotation
     */
    @Before("@annotation(logAnnotation)")
    public void afterPrintLog(JoinPoint joinPoint, LogAnnotation logAnnotation){
        System.out.println("================ after =================");
        System.out.println(joinPoint);
        System.out.println(logAnnotation.value());
        System.out.println("================ after =================");
    }

    /**
     * 使用多个切点
     * @param point
     */
    @Before("pcut1() || pcut2()")
    public void beforeController(JoinPoint point) {
        System.out.println("================ pcut after =================");
        System.out.println(point.getSignature().getDeclaringType());
        System.out.println("================ pcut after =================");
    }
}
