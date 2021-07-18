package com.xubo.algorithm;

/**
 * @Author Druid_Xu
 * @Date 2020/11/12 上午 09:05
 * @Description
 */
public class FindMaxString {

    public static void main(String[] args) {
        int[] next = getNext("abaacdou");
        int[] next1 = getNext1("abaacdou");
        for (int i : next1) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int[] getNext1(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k]; // 回退
            }
        }
        return next;
    }
}
