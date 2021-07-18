package com.xubo.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @Author Druid_Xu
 * @Date 2020/12/7 上午 11:47
 * @Description
 * DEFAULT_CAPACITY
 */
public class ArrayListDemo {

    @Test
    public void removeRepeat() {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("abd");
        list.add("bbb");
        list.add("abc");
        list.add("bbb");
        list.add("bbb");
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("abc"));

    }

}
