package com.xubo.current.breakfastdemo;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 上午 10:29
 * @Description 使用 CountDownLatch 时间从 4s 变成 了 3 秒，说明什么问题，就是 准备凉菜的同时也在准备包子
 * 两者是同时执行的，但是在 OrderBreakFast 这个类里面这两个动作是并行执行的，
 * <p>
 * 场景 ： 如果有一个业务需要同时调用 a b c d 四个接口，d接口依赖a b c 的结果
 * 如果串行执行，执行时间就是四个接口运行时长的总和，但是如果使用 CountDownLatch，运行时间
 * 就是 a b c 中执行时间最长的那个加上 d 的时间，大大提高了系统的响应速度
 *
 * executorService.excutor() 没有返回值 ，没有办法获取线程的执行状态
 * executorService.submit()  方法 返回一个future对象 然后从future 对象中 获取线程的执行状态
 *
 */
public class OrderBreakFastCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService pool = Executors.newCachedThreadPool();

        long start = System.currentTimeMillis();

        ColdDishThreadOnCDL coldDishThreadOnCDL = new ColdDishThreadOnCDL(latch);
        BumThreadOnCDL bumThreadOnCDL = new BumThreadOnCDL(latch);
        pool.execute(coldDishThreadOnCDL);
        pool.execute(bumThreadOnCDL);

//        Submits a Runnable task for execution and returns a Future
/*        Future<String> bum = (Future<String>) pool.submit(bumThreadOnCDL);
        try {
            String s = bum.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        try {
            latch.await();
            long end = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            System.out.println(sdf.format(end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end ? ");
    }

}

class ColdDishThreadOnCDL extends Thread {

    private CountDownLatch countDownLatch;

    public ColdDishThreadOnCDL(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("凉菜准备完毕");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BumThreadOnCDL extends Thread {

    private CountDownLatch countDownLatch;

    public BumThreadOnCDL(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("包子准备完毕");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
