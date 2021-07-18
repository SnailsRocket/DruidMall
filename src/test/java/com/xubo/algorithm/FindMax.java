package com.xubo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 上午 08:41
 * @Description
 */
public class FindMax {

    public static void main(String[] args) {
//        algorithm1();
//        algorithm2();
//        algorithm3();
//        algorithm4();
//        algorithm5(); 2^6
        algorithm6();
    }

    private static void algorithm1() {
        int[] arrs = {9, 6, 12, 3, 7};
        int max = arrs[0];
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] > max) {
                max = arrs[i];
            }
        }
        System.out.println(max);
    }

    private static void algorithm2() {
        int[] arrs = {9, 6, 12, 3, 7};
        Arrays.sort(arrs);
        System.out.println(arrs[0]); // 3
        System.out.println(arrs[arrs.length - 1]);  // 12
    }

    private static void algorithm3() {
        int length = 16;
        int i = 0;
        while (length != 1) {
            length = length / 2;
            i++;
        }
        System.out.println(i * 5);
    }

    /**
     * 有一个10cm的面包，小灰第一次吃1cm花1min，第二次吃1cm比上一次多1min
     * time time+1 time +2 time + 3
     */
    private static void algorithm4() {
        int length = 10;
        int time = 0;
        int sum = 0;
        while (length != 0) {
            time = time + 1;
            sum = sum + time;
            length--;
        }
        System.out.println(time);
        System.out.println(sum);
    }

    /**
     * 查找数组中第一个出现重复的数
     * 也可以使用set 或者 map集合来写
     */
    private static void algorithm5() {
        int[] arrs = {12,8,9,4,6,11,2,8};
        int count = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = i+1; j < arrs.length; j++) {
                if(arrs[i] == arrs[j]) {
                    System.out.println(arrs[i]);
                    break;
                }
                count++;
            }
        }
        System.out.println(count);
    }

    private static void algorithm6() {
        int[] arrs = {12,8,9,4,6,11,2,8};
        List list = new ArrayList<Integer>();
        for (int i = 0; i < arrs.length; i++) {
            if(list.contains(arrs[i])) {
                System.out.println(arrs[i]);
                break;
            }
            list.add(arrs[i]);
        }
    }
}
