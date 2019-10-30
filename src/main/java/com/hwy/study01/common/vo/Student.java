package com.hwy.study01.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description 学生类
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:36 2019-10-29
 * @Version     v1
 **/

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable{

    private String name;

    private Integer age;

    /**
     * 选修课
     */
    private Subject subject;

    @Override
    public Object clone() {
        //浅拷贝
        try {
            // 直接调用父类的clone()方法
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


    public static void main(String[] args) {
        Subject subject = new Subject("qwe", "t1");
        Student student = new Student("zhangsan",18, subject);
        System.out.println(subject);
        System.out.println(student.getSubject());




    }
}
