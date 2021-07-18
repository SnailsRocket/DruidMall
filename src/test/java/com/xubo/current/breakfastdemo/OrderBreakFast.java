package com.xubo.current.breakfastdemo;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 上午 10:19
 * @Description
 * 小胖去吃早餐，店家准备凉菜需要一分钟，准备包子需要3分钟
 * 常规执行 先执行 ColdDishThread 再执行 Bum
 * 把join() 方法放在 两个start() 的 后面，会发现执行时间从 6 编程了 4
 * 常规的 join() 在start() 后面 执行时间是6s ，2s 凉菜就出来了，所以后面的两个例子 没用
 * 场景应该是 ： a b c d 四个接口，d 接口依赖 a b c 三个的结果，这个时候才用CountDownLatch(
 *  最重要的一点不知道接口的执行时间)
 *
 *  Executor Executors ExecutorService  这三个类/接口的区别,三者都属于Executor框架中的一部分
 *  https://blog.csdn.net/weixin_40304387/article/details/80508236
 *
 */
public class OrderBreakFast {

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        ColdDishThread coldDishThread = new ColdDishThread();
        coldDishThread.start();
        coldDishThread.join();
//        Waits for this thread to die.

        BumThread bum = new BumThread();
        bum.start();

//        join()  description   Waits for this thread to die.两个线程同时 start,然后同时wait 3s
//        coldDishThread.join();
        bum.join();

        long end = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        System.out.println(sdf.format(end-start));

    }

}

class ColdDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class BumThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

