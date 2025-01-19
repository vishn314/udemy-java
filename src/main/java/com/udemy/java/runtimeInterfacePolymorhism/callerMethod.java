package com.udemy.java.runtimeInterfacePolymorhism;

public class callerMethod {
    public static void main(String[] args) {
        Clock c = new Clock();
        setAlarmON(c);
        Iphone i = new Iphone();
        setAlarmON(i);
        GoogleMini g = new GoogleMini();
        setAlarmON(g);
    }

    private static void setAlarmON(Alarm c) {
        c.setAlarm();
    }

    /*
    * Without Interface poly Morphism we will have to create three methods for each of the object types. as below
     */

//    private static void setAlarmON(Clock c) {
//        c.setAlarm();
//    }
//    private static void setAlarmON(Iphone c) {
//        c.setAlarm();
//    }
//    private static void setAlarmON(GoogleMini c) {
//        c.setAlarm();
//    }

}
