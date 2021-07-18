package com.xubo.current.breakfastdemo;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 上午 10:55
 * @Description
 *
 * 采用 Future 模式 也可以实现跟 CountDownLatch 一样的效果
 * 两个线程同时执行
 * TODO： 这个两个线程加上 join() 这个方法之后，执行时间也是 6 s，这个例子有问题 CSDN  https://blog.csdn.net/u014209205/article/details/80598209
 *
 */
public class OrderBreakFastOnFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Callable<String> ca1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "凉菜准备完毕！";
            }
        };
        FutureTask<String> ft1 = new FutureTask<>(ca1);
        Thread t1 = new Thread(ft1);
        t1.start();
//        t1.join();

        Callable<String> ca2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(4000);
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<>(ca2);
        Thread t2 = new Thread(ft2);
        t2.start();
//        t2.join();


        CompletableFuture<String> future1 = new CompletableFuture<>();

        future1.complete("do");
        future1.get();
        future1.cancel(false);

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        System.out.println(sdf.format(end-start));

    }

}
