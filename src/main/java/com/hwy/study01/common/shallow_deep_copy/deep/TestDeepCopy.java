package com.hwy.study01.common.shallow_deep_copy.deep;

import com.hwy.study01.common.vo.DeepStudent;
import com.hwy.study01.common.vo.DeepSubject;

/**
 * @Description 类描述
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        16:21 2019-10-29
 * @Version     v1
 **/
public class TestDeepCopy {

    /**
     *      (1) 对于基本数据类型的成员对象，因为基础数据类型是值传递的，所以是直接将属性值赋值给新的对象。基础类型的拷贝，其中一个对象修改该值，不会影响另外一个（和浅拷贝一样）。
     *      (2) 对于引用类型，比如数组或者类对象，深拷贝会新建一个对象空间，然后拷贝里面的内容，所以它们指向了不同的内存空间。改变其中一个，不会对另外一个也产生影响。
     *      (3) 对于有多层对象的，每个对象都需要实现 Cloneable 并重写 clone() 方法，进而实现了对象的串行层层拷贝。
     *      (4) 深拷贝相比于浅拷贝速度较慢并且花销较大
     *
     * 结果：
     *      student：DeepStudent(name=张三, age=18, subject=DeepSubject(name=数学, teacher=t1))
     *      studentB：DeepStudent(name=李四, age=20, subject=DeepSubject(name=英语, teacher=t2))
     * @param args
     */
    public static void main(String[] args) {

        DeepSubject subject = new DeepSubject("数学","t1");
        DeepStudent student = new DeepStudent("张三", 18, subject);
        DeepStudent studentB = (DeepStudent) student.clone();
        studentB.setName("李四");
        studentB.setAge(20);
        DeepSubject subject1 = studentB.getSubject();
        subject1.setName("英语");
        subject1.setTeacher("t2");
        studentB.setSubject(subject1);
        System.out.println("student："+student);
        System.out.println("studentB："+studentB);

    }

}
