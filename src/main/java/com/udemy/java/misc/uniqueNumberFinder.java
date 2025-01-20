package com.udemy.java.misc;

import java.util.HashMap;
import java.util.Map;

public class uniqueNumberFinder {
    public static void main(String[] args) {
        int input[] = {4, 5, 5, 5, 4, 6, 6, 9, 4};
        HashMap<Integer, Integer> inputHashMap = new HashMap<Integer, Integer>();
        for(int i =0; i < input.length;i++){
            if (!inputHashMap.containsKey(input[i])){
                inputHashMap.put(input[i],1);
            } else
            {
                inputHashMap.put(input[i], inputHashMap.get(input[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> eachEntryInHashMap : inputHashMap.entrySet()) {
            System.out.println(eachEntryInHashMap.getKey() + " is repeated " + eachEntryInHashMap.getValue() + " times");
            if (eachEntryInHashMap.getValue()  == 1) {
                System.out.println(eachEntryInHashMap.getKey() + " is the unique number");
            }
        }
    }
}
