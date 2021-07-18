package com.xubo.leetcode;

import java.util.HashMap;

/**
 * @Author Druid_Xu
 * @Date 2020/12/14 上午 09:51
 * @Description
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] arrs = twoSum(nums, 9);
        System.out.println(arrs[0]);
        System.out.println(arrs[1]);

        int[] ints = twoSum1(nums, 9);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arrs = new int[2];
        int temp = 0;
        for (int i = 0; i < nums.length-1; i++) {
            temp = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == temp) {
                    arrs[0] = i;
                    arrs[1] = j;
                }
            }
        }
        return arrs;
    }

    /**
     * 补数法 ： 将补数存入map集合中，补数为键 下标为 值  比上面那个少循环一次
     * 假如  2 7 11 15    9
     * 首先循环  i=0  map.put(7,1)
     *         i=1  map.get(key) != null 存入数组
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();    // 以 补数 为键，下标 为值
        int[] res = new int[2];
        for(int i=0; i < nums.length; i++) {
            int other = target - nums[i];

            if(map.get(other) !=null) {
                res[0] = i;
                res[1] = map.get(other);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
