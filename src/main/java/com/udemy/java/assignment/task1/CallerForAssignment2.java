package com.udemy.java.assignment.task1;

import java.util.ArrayList;
import java.util.List;

public class CallerForAssignment2 {
    public static void main(String[] args) {
        int onscreenNumber = 5;
        int enteredNumbers[] = {2, 3, 7, 2, 3};
        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;
        List<MathOperation> operationSequence = new ArrayList();
        operationSequence.add(add);
        operationSequence.add(sub);
        operationSequence.add(multiply);
        operationSequence.add(add);
        operationSequence.add(divide);
        //5+2-3*7+2/3
        for (int i =0; i< enteredNumbers.length; i++){
            onscreenNumber = calculate(onscreenNumber, operationSequence.get(i), enteredNumbers[i]);
        }
        System.out.println("final result :"+onscreenNumber);
    }
    private static int calculate(int onScreenNumber, MathOperation o, int enteredNumber) {
        return o.operate(onScreenNumber, enteredNumber);
    }
}

