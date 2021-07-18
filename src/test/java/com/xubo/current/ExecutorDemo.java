package com.xubo.current;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Druid_Xu
 * @Date 2020/11/23 上午 08:56
 * @Description
 *   Executor 框架是 Java5 之后引进的，在 Java 5 之后，通过 Executor 来启动线程比
 * 使用 Thread 的 start 方法更好，除了更易管理，效率更好（用线程池实现，节约开销）外，
 * 还有关键的一点：有助于避免 this 逃逸问题
 *   补充：this 逃逸是指在构造函数返回之前其他线程就持有该对象的引用. 调用尚未构造完全的
 * 对象的方法可能引发令人疑惑的错误。
 *   Executor 框架不仅包括了线程池的管理，还提供了线程工厂、队列以及拒绝策略等，Executor
 * 框架让并发编程变得更加简单。
 *   Executor 框架的结构  Runnable(任务)、Executor(任务的执行)、Future(异步执行的结果)
 */
public class ExecutorDemo {

    public static void main(String[] args) {
//        new ExecutorService();
//
//        new Executor();
//        new ThreadPoolExecutor();

        int[] arrs = {9,5,12,23,7,45,39};

        for (int i = 0; i < arrs.length-1; i++) {
            for (int j = i+1; j < arrs.length; j++) {
                if(arrs[j] > arrs[i]) {
                    arrs[i] = arrs[i] + arrs[j];
                    arrs[j] = arrs[i] - arrs[j];
                    arrs[i] = arrs[i] - arrs[j];
                }
            }
        }
        for (int arr : arrs) {
            System.out.print(arr + "  ");
        }

    }

}
