package com.xubo.current;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.context.request.RequestContextHolder;

/**
 * @Author Druid_Xu
 * @Date 2020/10/12 上午 11:07
 * @Description
 * CountDownLantch 与 CompletableFuture 的 区别 都是 concurrent包下
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
//        new CompletableFuture<>();

        CompletableFuture<Object> completableFuture = new CompletableFuture<>();
        CountDownLatch latch = new CountDownLatch(50);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            CountRunnables runs = new CountRunnables(latch);
//            runs.run();
            pool.execute(runs);
        }
    }
}

class CountRunnables implements Runnable{
    private CountDownLatch countDownLatch;

    public CountRunnables(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                countDownLatch.countDown();
                System.out.println("Thread count = " + countDownLatch.getCount());
            }
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}