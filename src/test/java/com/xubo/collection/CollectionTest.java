package com.xubo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/25 上午 08:45
 * List 和 Set 都是继承 Collection
 */
public class CollectionTest {

    public static void main(String[] args) {
        System.out.println(7 % 2); // 1

        List<String> list = new ArrayList<>();
        List<String> link = new LinkedList<>();

        Set set = new HashSet<>();
        Set treeSet = new TreeSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        Map<String, Integer> map = new HashMap<>(16);
        Map<String, Integer> table = new Hashtable<>();
        Map concurrentHashMap = new ConcurrentHashMap<>(16);
        Collections.emptyList();
//        基于 Collections 的 二分查找 效率明显 比 List 的 indexOf 和 lastIndexOf 快
        Collections.binarySearch(list, "Druid");
//        new Vector<>()
//        创建 Spring应用上下文， 运行会导致 StackOverFlowException
        ApplicationContext application = new ClassPathXmlApplicationContext();
        Object druid = application.getBean("Druid");


    }

}
