package com.xubo.invoke;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.xubo.test.Person;

/**
 * @Author Druid_Xu
 * @Date 2020/11/19 上午 10:08
 * @Description 反射越过泛型检测
 *  需求：
 *         我给你一个ArrayList<Integer>的一个对象，我想在这个集合上添加一个String类型的数据，如何解决？
 *     分析：
 *         1：在通常情况下，我们是不能添加String类型进集合的，因为泛型规定了Integer类型
 *         2：代码中的Integer仅仅是给编译器看的，而反射拿到的是字节码文件对象--也就是源码
 *         3：泛型的默认类型是Object
 *    实现：
 *         1:  创建集合对象
 *         2： 通过集合对象获取Class对象
 *         3： 通过Class对象获取Method对象
 *         4： 调用invoke方法实现功能
 *
 */
public class MyInvokeHandler {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        List<Integer> list = new ArrayList<Integer>();

//        获取List集合的字节码对象
        Class<? extends List> listClass = list.getClass();

//        通过字节码对象，获取到对象的方法，指定了add方法，参数是Object.class(但是实际上泛型类型为Integer)
//        ，所以invoke的时候就是add方法
        Method addMethod = listClass.getMethod("add", Object.class);
//        调用通过反射生成的方法，添加String类型的数据
        addMethod.invoke(list,"Druid");
        addMethod.invoke(list,"Druid1");
        addMethod.invoke(list,"Druid3");
        list.add(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /**
         * 通过反射获取构造方法,
         * 有 bug  NoSuchMethodException 通过反射构造有参构造的时候，找不到
         *
         */
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();
//        返回的是构造方法的对象
        Constructor<? extends Person> personClassConstructor =
                personClass.getConstructor(String.class,Integer.class,String.class);
//                personClass.getConstructor();
        Person obj = personClassConstructor.newInstance("Druid",23,"江苏");
        System.out.println(obj.toString());

    }
}
