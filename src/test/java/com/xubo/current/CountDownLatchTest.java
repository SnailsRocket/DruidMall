package com.xubo.current;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Xubo
 * @Date: 2020/10/11 16:05
 *
 * countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
 * 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，
 * 当计数器的值为0时，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了
 *
 * 作者：指尖架构141319
 * 链接：https://www.jianshu.com/p/e233bb37d2e6
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
 * public void await() throws InterruptedException { };
 * //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
 * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
 * //将count值减1
 * public void countDown() { };
 *
 * 场景题: 完成一个业务需要调用有4个接口(线程)a,b,c,d，最终以d接口为结尾，在这里a b c 的结果相互没有影响，
 *         但是他们都影响d(d依赖a b c接口的结果)
 *    方案1： 传统的方案是 a b c d 顺序调用
 *    方案2:  方案1的优化 使用 CountDownLatch这个类 在java.util.concurrent 并发包下，a b c，同时执行，d等待他们都执行完再执行
 *         问题: 方案2中如果有接口执行时间过长会导致d 的执行时间也很长，然后不好确定是哪个接口执行时间长
 *
 *
 * 2500 1000 600 1600
 * 1600 600
 *
 *  1199  869  2068  双十一原价
 *  799   789  1588  折扣价
 *  619   448  1067  11价
 *  580   421  1001  省
 *  500   400  900   平时价
 *  总结就一句话，太坑了
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程开始执行..... .....");

        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+ Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();

//        第二个线程开始执行 1<<4 = 10000
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
//            在此调用了await方法，此时必须要等待es1 和 es2 执行完毕才会执行下面的语句，
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");

    }

}
