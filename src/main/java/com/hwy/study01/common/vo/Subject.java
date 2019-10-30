package com.hwy.study01.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description 学科
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:35 2019-10-29
 * @Version     v1
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private String name;

    private String teacher;

    public static void main(String[] args) {

    }

}
