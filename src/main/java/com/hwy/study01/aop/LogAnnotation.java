package com.hwy.study01.aop;


import java.lang.annotation.*;

/**
 * @Description 日志的自定以注解
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        12:15 2019-10-31
 * @Version     v1
 *
 * @Target注解，是专门用来限定某个自定义注解能够被应用在哪些Java元素上面的
    类，接口（包括注解类型）或枚举的声明 TYPE,
    属性的声明  FIELD,
    方法的声明  METHOD,
    方法形式参数声明  PARAMETER,
    构造方法的声明  CONSTRUCTOR,
    局部变量声明  LOCAL_VARIABLE,
    注解类型声明  ANNOTATION_TYPE,
    包的声明  PACKAGE

   @Retention注解，翻译为持久力、保持力。即用来修饰自定义注解的生命力
    SOURCE  注解将被编译器忽略掉
    CLASS   注解将被编译器记录在class文件中，但在运行时不会被虚拟机保留，这是一个默认的行为
    RUNTIME 注解将被编译器记录在class文件中，而且在运行时会被虚拟机保留，因此它们能通过反射被读取到
   @Documented注解，是被用来指定自定义注解是否能随着被定义的java文件生成到JavaDoc文档当中。
   @Inherited注解，是指定某个自定义注解如果写在了父类的声明部分，那么子类的声明部分也能自动拥有该注解。@Inherited注解只对那些@Target被定义为ElementType.TYPE的自定义注解起作用
 **/
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String value();
}
