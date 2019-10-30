package com.hwy.study01.common.di_gui;

public class TestDigui2 {


    /**
     * 循环了3 次 所以 有 array[i] + array[i] + array[i]
     * @param array
     * @param i
     * @return
     */
    public static int unknow(final int[] array, int i) {
        if(i == array.length -1){
            return array[array.length-1];
        } else {
            return array[i] + unknow(array, i+1);
        }

    }

    public static void main(String[] args) {
        System.out.println(unknow(new int[] {1,1,1,1,1,1}, 2));
    }
}
