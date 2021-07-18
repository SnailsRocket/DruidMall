package com.xubo.Interview.sz.fourkmiles.java;

import com.xubo.Interview.sz.fourkmiles.entity.People;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author Xubo
 * @Date 2021/6/6 22:28
 * 测试 Java SPI机制
 * https://blog.csdn.net/qq_27292113/article/details/100324127  参考
 */
public class TestSPI {

    public static void main(String[] args) {
        ServiceLoader<People> peopleServiceLoader = ServiceLoader.load(People.class);
        Iterator<People> peopleIterator = peopleServiceLoader.iterator();
        while (peopleIterator.hasNext()) {
            People people = peopleIterator.next();
            people.people();
        }


    }

}
