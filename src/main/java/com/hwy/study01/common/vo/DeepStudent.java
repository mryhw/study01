package com.hwy.study01.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepStudent implements Cloneable{

    private String name;

    private Integer age;

    /**
     * 选修课
     */
    private DeepSubject subject;


    @Override
    public Object clone() {
        //浅拷贝
        try {
            // 直接调用父类的clone()方法
            DeepStudent student = (DeepStudent) super.clone();
            student.subject = (DeepSubject)subject.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
