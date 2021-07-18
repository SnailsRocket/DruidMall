package com.xubo.Interview;

/**
 * @Author : Druid
 * @Data ; 2021.5.7
 * @Description :
 *  思路：创建两个线程，线程1获取到i资源，就锁住ThreadInstance这个类(synchronized)，
 *      并调用notify方法，唤醒在此对象监视器上等待的线程，执行完打印后，就让调用wait()方法，
 *      使当前线程进入到休眠状态
 */
public class ThreadPrint {

    public static void main(String[] args) {
        ThreadInstance threadInstance = new ThreadInstance();
        Thread thread1 = new Thread(threadInstance);
        Thread thread2 = new Thread(threadInstance);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

}
class ThreadInstance implements Runnable {

    int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i < 101) {
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
