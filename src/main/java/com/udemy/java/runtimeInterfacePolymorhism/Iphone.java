package com.udemy.java.runtimeInterfacePolymorhism;

public class Iphone implements Alarm{
    public void makeCalls(){
        System.out.println("iPhone can make calls");
    }

    public void takePictures(){
        System.out.println("iphone can take pictures");
    }
    @Override
    public void setAlarm() {
        System.out.println("iphones implementation of alarm");
    }
}
