package com.xubo.string;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Druid_Xu
 * @Date 2020/12/2 上午 09:46
 * @Description
 * 装箱： 将基本数据类型转换成引用数据类型  int -> Integer
 * 拆箱： 将引用数据类型转换成基本数据类型 Integer -> int
 * 类的构造方法 完成对该类进行初始化的操作
 * == 与 equals 的区别
 *  == 比较的是两个对象的地址值是否一样， equals(如果重写Object的equals方法 String重写过) 比较的是两个对象的内容是否一致
 * length 是针对数组   length() 是针对字符串   size() 是针对泛型集合的
 */
public class StringDemo {

    public static void main(String[] args) {
        // 操作少量数据使用
        String s1 = new String();
        // 线程安全 对方法加上了同步锁 synchronized 多线程操作大量数据
        StringBuffer stringBuffer = new StringBuffer();
        // 线程不安全 但是效率较高 单线程操作大量数据
        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<String>();
        List<String> linkList = new LinkedList<String>();

        Map<String,String> map = new HashMap<String,String>();

        Set<String> set =new HashSet<String>();

        Map<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        TreeMap<String,String> treeMap = new TreeMap<String,String>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 不需要获取同步的 monitor 和 synchronized 信息，但

    }
}
