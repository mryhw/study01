package com.hwy.study01.common.vo;

/**
 * @Description 测试 原子引用的实体类
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        15:21 2019-10-29
 * @Version     v1
 **/
public class User {

    private String user;

    private String age;

    public User(String user, String age) {
        this.user = user;
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
