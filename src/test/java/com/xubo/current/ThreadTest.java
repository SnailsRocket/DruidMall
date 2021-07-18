package com.xubo.current;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 上午 10:01
 * @Description
 * 实现多线程的多种方式
 * 1.实现Runnable 接口
 * 2.继承Thread 类
 * 3.使用 Executors 创建线程池 (一般都使用这种方式使用线程，
 *  使用多线程就涉及到线程安全问题，就会扯到锁，乐观锁、悲观锁、自旋锁、轻量级锁、
 *  重量级锁、共享锁、排他锁、可重入锁、不可重入锁、公平锁、非公平锁)
 *  锁详解  https://www.cnblogs.com/jyroy/p/11365935.html
 *
 */
public class ThreadTest extends Thread {

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        t.run();

    }

    @Override
    public void run() {
        System.out.println("running");
    }
}
