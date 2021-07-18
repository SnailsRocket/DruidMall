package com.xubo.DuckAndTurkey;

/**
 * @Author Druid_Xu
 * @Date 2020/12/8 上午 10:58
 * @Description
 * duck 鸭子  quack()   turkey 火鸡 gobble() 方法
 * 目标：想让 Turkey 的 gobble() 方法适配 duck 的 quack方法 ,从而让火鸡冒充鸭子
 * 执行流程 ： 首先创建 Duck 和 Turkey 的实现类
 *  创建 TurkeyAdapter 这个类的时候，会自动加载他爱的构造方法，
 *  当运行 duck.quack() 的时候，直接转到 TurkeyAdapter 的 quack() 方法，方法里面 turkey对象调用gobble()
 *
 */
public class Client {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack(); // 但是最后会执行 Turkey 的 globble() 方法
    }
}
