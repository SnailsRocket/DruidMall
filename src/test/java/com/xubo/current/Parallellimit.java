package com.xubo.current;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Xubo
 * @Date: 2020/10/11 16:28
 *
 * 模拟并发示例  CountDownLatchTest的例子
 */
public class Parallellimit {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cd1 = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            CountRunnable runnable = new CountRunnable(cd1);
            pool.execute(runnable);
        }
    }
}

class CountRunnable implements Runnable {

    private CountDownLatch countDownLatch;

    public CountRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                countDownLatch.countDown();
                System.out.println("Thread count = " + countDownLatch.getCount());
            }
//            50个线程执行完了才执行下面的语句，所以输出的首饰100
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
