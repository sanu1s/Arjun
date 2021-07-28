package com.sample.Mytest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    interface myInterface{
    public void lambda();
    //public void lambda1();
    }
   /* public static class  myClass implements myInterface{

        public void lambda(){
            System.out.println("Hello!!!!");
        }
    }*/


    public static void main(String args[]){
        myInterface myInterface=()->System.out.println("Super");
        myInterface.lambda();
        System.out.println("Checking for Executor Service");
        Executor executor= Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task1"+ Thread.currentThread());
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task2"+ Thread.currentThread());
            }
        });

    }


}
