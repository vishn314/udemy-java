package com.udemy.java.datatype;

import java.util.Arrays;

public class PrimitiveType {

    public static void main(String[] args) {

        int i = 5;
        System.out.println("Before :: " + i);
        change(i);
        System.out.println("After :: " + i);

        int[] arr = new int[] {1, 2, 3};
        System.out.println("passed reference:"+arr);
        System.out.println(" Before :: " + Arrays.toString(arr));
        changeArr(arr);
        System.out.println("After :: " + Arrays.toString(arr));

    }

    //5
    private static void change(int a){
        //6
        a++; //a=a+1
    }

    private static void changeArr( int [] a){
        System.out.println("caught reference:"+a);
        a = Arrays.copyOf(a,a.length);
        a[0]++;
        a[1]++;
        a[2]++;
        System.out.println("caught reference:"+a);
    }


}