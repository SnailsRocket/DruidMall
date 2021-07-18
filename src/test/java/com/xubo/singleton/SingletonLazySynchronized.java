package com.xubo.singleton;


/**
 * @Author Druid_Xu
 * @Date 2020/12/3 上午 09:27
 * @Description
 * 单例模式 同步方法懒汉模式
 */
public class SingletonLazySynchronized {
    private SingletonLazySynchronized singletonLazySynchronized = null;

    private SingletonLazySynchronized() {
    }

    public synchronized SingletonLazySynchronized getInstance() {
        if(this.singletonLazySynchronized == null) {
            this.singletonLazySynchronized = new SingletonLazySynchronized();
        }
        return this.singletonLazySynchronized;
    }
}
