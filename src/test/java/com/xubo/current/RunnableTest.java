package com.xubo.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 上午 09:02
 * @Description
 */
public class RunnableTest implements Runnable {

    public static void main(String[] args) {
        RunnableTest r = new RunnableTest();
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(r);
//        r.run();

    }

    @Override
    public void run() {
        System.out.println("run。。。");
    }
}
