package com.udemy.java.runtimeInterfacePolymorhism;

public class GoogleMini implements Alarm{

    public void answerQuestions(){
        System.out.println("give voice answers to questions");
    }
    @Override
    public void setAlarm() {
        System.out.println("google minis implemenation of alamr");
    }
}
