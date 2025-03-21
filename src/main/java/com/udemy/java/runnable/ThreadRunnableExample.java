package com.udemy.java.runnable;

public class ThreadRunnableExample {
    public static void main(String[] args) {
        Runnable myRunnable = () -> System.out.println("Thread running from Runnable.");
        Thread mythread = new Thread(myRunnable);
        mythread.start();
    }
}
