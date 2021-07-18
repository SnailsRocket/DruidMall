package com.xubo.extend;/**
 * @Author Druid_Xu
 * @Create 2020/9/29 下午 04:04
 * TODO :
 */


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/29 下午 04:04
 *
 * 这个是test文件夹，故不能使用@Autowired 或者  @Resource， 只能 new，没有ComponentScan这个注解
 * 静态代理 可以做到不修改目标对象(class、interface)的情况下，对目标功能进行扩展
 * cglib  JDK动态代理
 *
 */
public class TestMultImplements {

    private static UserExtendsImpl userExtends = new UserExtendsImpl();

    public TestMultImplements(UserExtendsImpl userExtends) {
        this.userExtends = userExtends;
    }

    public static void main(String[] args) {

        String[] strs = {"Druid","Xubo","chenzikun"};
        int[] nums = {7,5,9,2};
        Integer[] ints = {21,12,45,90};

        List<String> nameList = Arrays.asList(strs);
        List<int[]> numsList = Arrays.asList(nums);
        List<Integer> intsList = Arrays.asList(ints);
//        nameList.add("liyaoting");
        for (String s : nameList) {
            System.out.println(s);
        }
        System.out.println("\n");

        System.out.println(numsList.size());
        for (int i = 0; i < numsList.size(); i++) {
            System.out.println(numsList.get(i));
        }
        System.out.println("\n");

        System.out.println(intsList.size());
        for (Integer integer : intsList) {
            System.out.println(integer);
        }
        System.out.println("\n");

//        获取系统时间，首先获取时间戳，然后使用 SimpleDateFormat将时间戳转换成 指定格式的时间
        long timeMillis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(timeMillis);
        System.out.println(format);
        Map<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String,Integer> map = new HashMap<>();

        userExtends.play();
        userExtends.sleep();
    }

}
