package com.udemy.java.assignment.task1;

public class CallerForAssignment1 {
    public static void main(String[] args) {
        /*
        add lambda function
         */
        MathOperation addition = (a,b) -> a+b;
        MathOperation substraction = (a,b)->a-b;
        MathOperation multiply = (a,b) -> a*b;
        MathOperation divide = (a,b) -> a/b;

        System.out.println(calculate(addition));;
        System.out.println(calculate(substraction));
        System.out.println(calculate(multiply));
        System.out.println(calculate(divide));
    }

    private static int calculate(MathOperation o){
        int a =100;
        int b =5;
        int result = o.operate(a,b);
        return result;
    }

}
