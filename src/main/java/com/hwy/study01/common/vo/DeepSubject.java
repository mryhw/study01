package com.hwy.study01.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepSubject implements Cloneable{

    private String name;

    private String teacher;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
