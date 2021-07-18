package com.xubo.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Druid_Xu
 * @Date 2020/12/8 上午 11:44
 * @Description
 * 题目： 给定一组数据，绝对值从小到大 ，并且给出一个值，让两数之和等于该数
 * 输入： [0,-1,2,-3,4]    [0,-1,3,-4,-5,7]
 *       1                2
 * 输出： [1,2] [3,4]      [1,2] [4,5]
 * 分析：
 *   判断正负，存储到map集合，相邻的元素相减，match 输入的就记录索引值
 * 思路：
 *
 */
public class NumCaculate {
    static List<List<Integer>> list = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] arr = {0,-1,2,-3,4};
        int[] arr1 = {0,-1,3,-4,-5,7};
//       caculate(arr,1);
       caculate(arr1,2);
    }

    public static void caculate(int[] arrs,int match) {
        Set<String> set = new HashSet<>();
        List<Integer> listchi = null;

        for (int i = 0; i < arrs.length-1; i++) {
            for (int j = i+1; j < arrs.length; j++) {
                if(arrs[i] + arrs[j] == match) {
                    listchi = new ArrayList<Integer>();
                    set.add("["+i+","+j+"]");
                    listchi.add(i);
                    listchi.add(j);
                    list.add(listchi);
                    break;
                }
            }
        }
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("=============");
        for (int i = 0; i < list.size(); i++) {
            List<Integer> integers = list.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j)+ "  ");
            }
            System.out.println();
        }
        System.out.println("=============");
    }
}
