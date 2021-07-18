package com.xubo.current;

/**
 * @Author Druid_Xu
 * @Date 2020/11/24 上午 11:50
 * @Description 死锁的产生
 * 线程1 抢占 resource1 并上锁，不释放
 * 线程2 抢占 resource2 并上锁，不释放
 * 最后导致程序死锁，不执行后面的语句
 *
 * 线程1 和 线程2 发生死锁
 * 线程1 和 线程3 可以执行下去，获取共享资源 线程1 拿到资源之后什么时候释放的了？
 *  synchronized 关键字 执行完就释放资源
 * sleep() 与 wait() 最大的区别是什么
 *  都是暂停线程的执行，但是sleep()没有释放锁，而wait方法释放了锁
 *  Wait 通常被用于线程间交互/通信，sleep 通常被用于暂停执行。
 *  wait() 方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的 notify()
 *      或者 notifyAll() 方法。sleep() 方法执行完成后，线程会自动苏醒。或者可以使用
 *      wait(long timeout)超时后线程会自动苏醒
 *
 */
public class DeadLockDemo {

    private static Object resource1 = new Object(); // 资源1
    private static Object resource2 = new Object(); // 资源1

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                // sleep 1000ms 之后，这个resource2 被线程2 锁住了，获取不到，在这边死等(死锁)
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程1").start();


        /*new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                // sleep 1000ms 之后，这个resource1 被线程1 锁住了，获取不到，在这边死等(死锁)
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程2").start();*/

        new Thread(() -> {
            synchronized(resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程3").start();

        System.out.println("DeadLockDemo 死锁，，这句是在main函数的最下边，但是会在创建线程2之前执行");

        /**
         * 先有字符串"abc"放入常量池，然后 new 了一份字符串"abc"放入Java堆(字符串常量"abc"在编译期就已经确定
         * 放入常量池，而 Java 堆上的"abc"是在运行期初始化阶段才确定)，然后 Java 栈的 s 指向Java堆上
         * 的"abc"。
         * 八种基本数据类型 Byte short char int float long double boolean
         * StringBuilder 与 StringBuffer 的区别
         *   StringBuilder 是线程不安全的 ，效率高
         *   StringBuffer 是线程安全的 ，查看底层代码，发现所有的方法都使用Synchronized 关键字修饰
         *
         */

        String s = new String("abc"); // 这句话创建了两个独享
        String s1 = "abc";
        System.out.println(s == s1); // false s 在 堆中， s1 在常量池中
        System.out.println(s.equals(s1)); // String 重写 equals 方法 比较的是value
    }

}
