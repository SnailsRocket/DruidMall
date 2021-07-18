package com.xubo.targetobject;

import java.lang.reflect.Method;

import com.xubo.test.Person;

/**
 * @Author Druid_Xu
 * @Date 2020/11/26 上午 08:39
 * @Description 反射
 * Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法，都能够调用它的任意一个
 * 方法和属性，这种动态获取信息的机制以及动态调用对象的方法的功能称为Java语言的反射机制
 * 获取 class 的 四种方式
 *  1.知道具体类的情况下可以使用：
 *  class objectClass = TargetObject.class;
 *  但是我们一般是不知道具体类的，基本都是通过遍历包下面的类来获取 Class 对象，通过此方式获取Class对象不会进行初始化
 *
 */
public class TargetObject {
    public static void main(String[] args) {

        //
        Class<Person> personClass = Person.class;


        //
        try {
            Class<?> aClass = Class.forName("com.xubo.test.Person");
            Class<?> gClass = Class.forName("com.xubo.utils.GetSystemUserName");
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person p = new Person();
        Class<? extends Person> pClass = p.getClass();

        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("com.xubo.test.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
