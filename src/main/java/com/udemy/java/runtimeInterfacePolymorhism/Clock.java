package com.udemy.java.runtimeInterfacePolymorhism;

public class Clock implements Alarm {
    
    public void showTime(){
        System.out.println("show time - clock");
    }

    @Override
    public void setAlarm() {
        System.out.println("clocks implementation of alarm");
    }
}
