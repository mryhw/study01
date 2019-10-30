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


    public static int unknow(int[] array, int i) {

        if(i == array.length - 1){
            return array[i];
        } else {
            int temp = unknow(array, i+1);
            return temp < array[i] ? array[i] : temp;
        }

        /**
         * length 4 i 0
         *
         * 4 i 2  temp = 3
         *
         *
         */
    }
    public static void main(String[] args) {
        System.out.println(unknow(new int[]{3,5,6,2}, 0));
    }





}
