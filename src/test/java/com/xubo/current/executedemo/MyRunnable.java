package com.xubo.current.executedemo;

import java.util.Date;

/**
 * @Author Druid_Xu
 * @Date 2020/11/24 下午 03:32
 * @Description
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    @Override
    public String toString() {
        return this.command;
    }
}
