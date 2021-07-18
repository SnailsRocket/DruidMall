package com.xubo.extend;/**
 * @Author Druid_Xu
 * @Create 2020/9/29 下午 04:01
 * TODO :
 */


/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/29 下午 04:01
 */
public class UserExtendsImpl implements UserExtends{

    public void sleep() {
        System.out.println("睡觉");
    }

    @Override
    public void play() {
        System.out.println("刺激战场！");
    }
}
