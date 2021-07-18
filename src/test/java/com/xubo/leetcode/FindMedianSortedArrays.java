package com.xubo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * @Author Druid_Xu
 * @Date 2020/12/14 下午 01:42
 * @Description 寻找两个正序数组的中位数
 * 程序计数器主要有以下两个作用 :
 * 1.字节码解释器通过改变程序计数器来依次读取指令，从而实现代码的流程控制，如：顺序执行、选择、循环、异常处理；
 * 2.在多线程环境下，程序计数器用于记录当前线程执行的位置，从而当前线程被切换回来的时候能够知道该线程上次执行到哪了。
 * <p>
 * 思路1： 将两个数组组合成一个数组，存入Set集合，然后根据奇偶返回中位数
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,4};
        int[] arr2 = new int[]{};
        double result = findMedianSortedArrays(arr1, arr2);
        System.out.println(result);
//        findMedianSortedArrays1(arr1,arr2);
        double midNum = findMedianSortedArrays2(arr1, arr2);
        System.out.println(midNum);
        double midNums = findMedianSortedArrays3(arr1, arr2);
        System.out.println("findMedianSortedArrays3 : " + midNums);
        double midNums1 = findMedianSortedArrays4(arr1, arr2);
        System.out.println(midNums1);

    }

    /**
     * 思路： 首先判断两个数组的长度是否为0，若为0则只计算一个数组的中位数，反之，先分别计算，然后在合起来计算一次
     * failed
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0d;
        } else if (nums1.length == 0) {
            for (int i = 0; i < nums2.length; i++) {
                int sum = 0;
                sum += nums2[i];
                return (double) sum / nums2.length;
            }
        } else if (nums2.length == 0) {
            for (int i = 0; i < nums1.length; i++) {
                int sum = 0;
                sum += nums1[i];
                return (double) sum / nums1.length;
            }
        } else {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < nums1.length; i++) {
                sum1 += nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                sum2 += nums2[i];
            }
            return (double) ((double) sum1 / nums1.length + (double) sum2 / nums2.length) / 2.0;
        }
        return 0;
    }

    /**
     * 将两个数组存入set集合并按照大小顺序排序，然后根据奇偶返回中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        return 0d;
    }

    /**
     * 使用ArrayList 集合存储两个数组合并后的数据，重复的数据不覆盖
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Collections.sort(list/*, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }*/);
        for (Integer integer : list) {
            System.out.print(integer + "  ");
        }
        System.out.println();
        if (list.size() % 2 == 0) {
            System.out.println("偶数 " + list.size());
            return (double) (list.get((list.size() - 1) / 2) + list.get(list.size() / 2)) / 2;
        } else {
            System.out.println("奇数 " + list.size());
            return (double) list.get(list.size() / 2);
        }
    }

    /**
     * 8ms     39.8m
     * 效率很低
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        int len = list.size();
        Collections.sort(list);
        if (len % 2 == 0) {
            return (double) (list.get((len - 1) / 2) + list.get(len / 2)) / 2;
        } else {
            return (double) list.get(len / 2);
        }
    }

    /**
     * 使用数组代替集合，上面是将两个数组合并到集合中，然后使用Collections 提供的工具类
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2 -1] + nums2[len2 / 2]) / 2.0;
            } else {
                System.out.println(len2/2 + 1);
                return nums2[len2 / 2];
            }
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                System.out.println(len1 / 2 -1);
                return (nums1[len1 / 2 -1] + nums1[len1 / 2]) / 2.0;
            } else {
                return nums1[len1 / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != (len1 + len2)) {
            if (i == len1) {
                while (j != len2) {
                    // nums1已经全部装入 nums里面
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == len2) {
                while (i != len1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        // nums 是从 索引 0 开始的 但是 count值就是nums里元素的个数
        System.out.println("count : " + count);
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

}
