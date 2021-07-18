package com.xubo.singleton;

/**
 * @Author Druid_Xu
 * @Date 2020/12/3 上午 09:45
 * @Description
 * 单例模式 之懒汉模式 double-check  双重检查
 * 这种写法，使用了两个if判断(double-check)，这样写更安全。并且同步的是代码块，效率(同步方法)比锁类要高很多。
 * 为什么要double-check了，主要还是为了安全考虑。
 * 假设有这样一个场景。A B 两个线程同时执行到第一个if 判断,然后 A 获得锁，进入同步代码块里面去执行，A执行完成之后释放
 * 锁，B获得了A释放的锁，B去代码块里面执行相应的操作，但是如果这个时候没有第二个判断，就会创建两个实例对象
 *
 */
public class SingletonLazySynchronizedPro {
    private volatile SingletonLazySynchronizedPro singletonLazySynchronizedPro;

    // 这个地方需要使用private 修饰，不然谁都可以调用无参构造创建单例对象，那么单例对象就不是单例对象
    private SingletonLazySynchronizedPro() {
    }

    public SingletonLazySynchronizedPro getInstance() {
        if(this.singletonLazySynchronizedPro == null) {
            synchronized (SingletonLazySynchronizedPro.class) {
                if(this.singletonLazySynchronizedPro == null) {
                    this.singletonLazySynchronizedPro = new SingletonLazySynchronizedPro();
                }
            }
        }
        return this.singletonLazySynchronizedPro;
    }
}
