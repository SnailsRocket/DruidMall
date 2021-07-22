package com.xubo.Interview.sz.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @Author Xubo
 * @Date 2021/7/21 22:25
 * 深圳 面试算法题
 */
public class AlgorithmTest {

    /**
     * 实现一个接口，不使用String.split 将 ab&&2 分割成 字符串数组 ["ab","2"]
     * 思路：首先将字符串转成字符数组，然后去一个个的拼接
     */
    @Test
    public void stringToArray() {
        String regex = "&";
        String str = "ab&&2";
        String[] strArr = new String[10];
        StringBuffer sb1 = new StringBuffer();
        int i = 0;
        char[] ch = {};
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            if (!regex.equals(String.valueOf(aChar))) {
                sb.append(aChar);
            } else {
                if (sb.length() != 0) {
                    sb1.append(sb.toString() + ",");
                    strArr[i++] = sb.toString();
                    sb.delete(0, sb.length());
                }
            }
        }
        sb1.append(sb.toString());
        strArr[i++] = sb.toString();

        int k = 0;
        System.out.println(sb1.toString());
        for (String s : strArr) {
            if (s != null) {
                System.out.print(s + "\t");
                k++;
            } else {
                break;
            }
        }
        System.out.println("k = " + k);
    }

    /**
     * 字符串组合 将["ab","2"] 通过分隔符，组合成字符串"ab&&2"
     */
    @Test
    public void arrayToString() {
        String[] strs = {"ab", "2"};
        String regex = "&&";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length - 1; i++) {
            sb.append(strs[i] + regex);
        }
        sb.append(strs[strs.length - 1]);
        System.out.println(sb.toString());
    }

    /**
     * 找出不大于n的最大质数
     * 质数： 只能被1 和 自己整除的数
     */
    @Test
    public void findMaxPrime() {
        int n = 30;
        for (int i = n-1; i > 0; i--) {
            if(isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    /**
     * 判断n是否是质数
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1000个数范围是[0-999]，有两个相同的数，请设计算法找出来
     * 思路：这个用排序做特别快，不建议用for循环
     *      或者将1换到第一个位置 2 放回第二个位置 直到有一个地方出现相同的元素  arr[i] = i
     */
    @Test
    public void findSmameNumber() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }
        arr[500] = 699;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            // 第i个位置的值是否等于i，不等就交换，如果相等就输出地址值
            // i = 9  arr[i] = 12  arr[arr[i]]
            if(arr[arr[i]] != i) {
                // 交换位置
                System.out.println(i + "=" + arr[i]);
                break;
            }
        }
    }

    /**
     *  n个人(编号1~n)围成从编号为1的开始报数，从1报数到m，报到m的人出来，下一个人继续从1开始报数，编程
     * 求出最后一个留下的人的编号
     * 如： n = 3   m = 4
     * 第一次出队 1
     * 第二次出队 3
     * 最后留下 2
     */
    @Test
    public void caculateNumber() {

    }

    /**
     * 有26个字母a-z，找出所有字母的组合 a,b,c,ab,a~z都是
     */
    @Test
    public void constituteLetters() {

    }

}
