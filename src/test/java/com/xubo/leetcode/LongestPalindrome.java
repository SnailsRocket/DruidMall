package com.xubo.leetcode;

import java.util.Arrays;

/**
 * @Author Druid_Xu
 * @Date 2020/12/15 下午 03:22
 * @Description 最长回文数
 * 输入 babab     cbbd
 * 输出 bab       bb
 * 注意： aba 也是一个答案
 */
public class LongestPalindrome {

    public static void main(String[] args) {

    }

    /**
     * 最长回文数
     *   递归
     *   动态规划
     * dp[i][j] s[i]==s[j] dp[i+1][j-1]  (j-1)-(i+1) +1 < 2 j-i<3
     * dp[i][j] -> dp[i+1][j-1] -> dp[i+2][j-2]  状态转移
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int[] indexs = new int[2];
        for (int start = 0, end = 0; end < chs.length; end++) {
            if(chs[start] == chs[end]) {
               start = start + 1;
               end = end - 1;

            }else {
                return "";
            }
        }
        return "";
    }

    public String isPalindrome(int start, int end, String s) {
        char[] chs = s.toCharArray();
        char[] chss = new char[]{};
        int count = 0;
        if(end - start < 3) {
            return s;
        } else {
            if(chs[end] == chs[start]) {
                for (int i = 1; i < chs.length-1; i++) {
                    chss[count++] = chs[i];
                }
                isPalindrome(start+1,end-1,chss.toString());
            }
            return "";
        }
    }

}
