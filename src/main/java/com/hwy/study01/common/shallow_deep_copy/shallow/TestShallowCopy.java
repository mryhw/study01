package com.hwy.study01.common.shallow_deep_copy.shallow;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hwy.study01.common.vo.Student;
import com.hwy.study01.common.vo.Subject;
import org.springframework.beans.BeanUtils;
import sun.security.ssl.SunJSSE;

/**
 * @Description 类描述
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:43 2019-10-29
 * @Version     v1
 **/
public class TestShallowCopy {

    /**
     * 定义：浅拷贝是按位拷贝对象，它会创建一个新对象，这个对象有着原始对象属性值的一份精确拷贝。
     *      如果属性是基本类型，拷贝的就是基本类型的值；如果属性是内存地址（引用类型），拷贝的就是内存地址 ，
     *      因此如果其中一个对象改变了这个地址，就会影响到另一个对象。即默认拷贝构造函数只是对对象进行浅拷贝复制(逐个成员依次拷贝)，即只复制对象空间而不复制资源
     *
     * 实现：实现对象拷贝的类，需要实现 Cloneable 接口，并覆写 clone() 方法
     *
     * 结果：
     *      student：Student(name=张三, age=18, subject=Subject(name=英语, teacher=t2))
     *      studentB：Student(name=李四, age=20, subject=Subject(name=英语, teacher=t2))
     *
     *
     * 结论：通过上面的例子可以看到，浅拷贝会带来数据安全方面的隐患，例如我们只是想修改了 studentB 的 subject，
     *      但是 studentA 的 subject 也被修改了，因为它们都是指向的同一个地址。所以，此种情况下，我们需要用到深拷贝。
     *
     *      BeanUtils.copyProperties() 属于浅拷贝
     *
     * @param args
     */

    public static void main(String[] args) {

        Subject subject = new Subject("数学","t1");
        Student student = new Student("张三", 18, subject);
        Student studentB = (Student) student.clone();
        studentB.setName("李四");
        studentB.setAge(20);
        Subject subject1 = studentB.getSubject();
        subject1.setName("英语");
        subject1.setTeacher("t2");
        studentB.setSubject(subject1);
        System.out.println("student："+student);
        System.out.println("studentB："+studentB);

        Student studentNew = new Student();
        BeanUtils.copyProperties(student, studentNew);

        Subject subject2 = studentNew.getSubject();
        subject2.setTeacher("newT2");
        subject2.setName("tiyu");

        System.out.println("=======================");
        System.out.println("student:" + student);
        System.out.println("studentNew:" + studentNew);

    }

}
