package com.xubo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Druid_Xu
 * @Date 2020/11/19 上午 08:45
 * @Description
 * 集合迭代器
 * iterator.hasNext() 判断集合中是否有元素
 * iterator.next 每执行一次，指针向后面移动一位
 *
 */
public class IteratorCode {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Druid");
        list.add("xubo");
        list.add("chen");
        list.add("liu");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

    }

}
