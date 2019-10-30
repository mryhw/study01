package com.hwy.study01.common.di_gui;


/**
 * 递归调用
 *
 * 首先 if 中 必须满足 i=3 temp 为 2， 而此时 在 else 中 i = 2
 *     此时 三元表达式 中 2<6 ? 6:2
 *     return 6
 */
public class TestDigui {


    public static int unknow(int[] array, int i) {

        if(i == array.length - 1){
            return array[i];
        } else {
            int temp = unknow(array, i+1);
            return temp < array[i] ? array[i] : temp;
        }

    }
    public static void main(String[] args) {
        System.out.println(unknow(new int[]{3,5,6,2}, 0));
    }
}
