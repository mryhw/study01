package com.hwy.study01.aop;


import java.lang.annotation.*;

/**
 * @Description 日志的自定以注解
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        12:15 2019-10-31
 * @Version     v1
 **/
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String value();
}
