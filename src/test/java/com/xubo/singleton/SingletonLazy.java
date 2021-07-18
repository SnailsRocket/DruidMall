package com.xubo.singleton;

/**
 * @Author Druid_Xu
 * @Date 2020/12/3 上午 09:20
 * @Description
 * 单例模式 之 懒汉模式
 * 用时才加载
 * 线程不安全 不可用
 */
public class SingletonLazy {

    private SingletonLazy singletonLazy = null;

    private SingletonLazy() {
    }

    public SingletonLazy getInstance() {
        return new SingletonLazy();
    }

}
