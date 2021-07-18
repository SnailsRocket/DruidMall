package com.xubo.thread;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/23 下午 04:41
 *
 * 没有加上 synchronized   i = 42
 * 加上 synchronized i = 40
 *
 *
 */
public class MulThread implements Runnable{

    static int i = 0;
    static int m = 20;
    private synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < m; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MulThread mulThread = new MulThread();
        Thread t1 = new Thread(mulThread);
        Thread t2 = new Thread(mulThread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
