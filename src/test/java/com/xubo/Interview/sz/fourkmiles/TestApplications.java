package com.xubo.Interview.sz.fourkmiles;


import com.xubo.mall.annotation.People;
import com.xubo.mall.entity.DownloadData;
import com.xubo.mall.entity.EDspAchievement;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/6/2 14:44
 */
public class TestApplications {

    public static void main(String[] args) {

        Optional<EDspAdSite> dspSiteOptional = Arrays.stream(EDspAdSite.values()).filter(e -> e.getSite().equalsIgnoreCase("us")).findFirst();

        System.out.println(dspSiteOptional.get().getCurrency());
        String str = "Druid  ";
        String str1 = " Druid";
        String str2 = "Dr u id";
        // trim 去掉字符串首尾的空格
        String trim = str.trim();
        System.out.println("trim:" + trim + "f");
        System.out.println("trim:" + str1.trim() + "f");
        System.out.println("trim:" + str2.trim() + "f");

        double pow = Math.pow(2, 6);
        System.out.println("pow:" + pow);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ServiceLoader<People> peopleServiceLoader = ServiceLoader.load(People.class);
        Iterator<People> iterator = peopleServiceLoader.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            System.out.println("before");
            next.study(23);
            System.out.println("after");
        }

        System.out.println(Optional.ofNullable(dspSiteOptional).isPresent());

    }

    /**
     * Integer 和 String 的 hash方法
     */
    @Test
    public void testObject() {
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1==i2);
        System.out.println(i1.hashCode() + "==" + i2.hashCode());
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("a");
        String str4 = new String("a");
        System.out.println(str3==str4);
        System.out.println(str3.hashCode() + "==" + str4.hashCode());
    }

    // 这两种方式没有从枚举中拿方便，效率也相对较低
    @Test
    public void addToList() {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        int[] arr1 = {1,2,3,4,5,6};

        List<int[]> ints = Arrays.asList(arr1);
        List<Integer> list = Arrays.asList(arr);

    }

    @Test
    public void testSwitch() {
        String[] strs = {"1", "3"};
        List<String> strList = new ArrayList<>();
        for (String str : strs) {
            switch (str) {
                case "1": {
                    strList.add("1");
                    strList.add("2");
                    strList.add("3");
                    break;
                }
                case "2": {
                    strList.add("4");
                    strList.add("5");
                    strList.add("6");
                    break;
                }
                case "3": {
                    strList.add("7");
                    strList.add("8");
                    strList.add("9");
                    break;
                }
            }
        }
        for (String s : strList) {
            System.out.print(s + "\t");
        }
    }

    /**
     * 对前端传过来的自定义选项进行格式化操作 前端传过来的1-17  对应后端的 1-51
     */
    @Test
    public void solveNumber() {
        Integer[] arrs = {1,2,3,4,5,6,7,8,10,12,14};
        List<Integer> arrList = Arrays.asList(arrs);
        List<Integer> ints = new ArrayList<>();
        arrList.stream().forEach(e -> ints.addAll(EDspAchievement.getIdByRange(e)));
        System.out.println(ints.size());
        for (Integer integer : ints) {
            System.out.print(integer+ "\t");
        }
    }


    /**
     * TODO: 使用 Stream 将List 转成 Map
     */
    @Test
    public void testStream() {



    }

}
