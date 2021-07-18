package com.xubo.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 下午 03:12
 * @Description
 */
public class GetGreatestCommonDivisor {

    public static void main(String[] args) {
        Integer greatesCommon = getGreatesCommon(9, 15);
        System.out.println(greatesCommon);

        Integer result1 = getGreatesCommon1(14, 21);
        System.out.println(result1);

        Integer result2 = getGreatesCommon3(68, 34);
        System.out.println(result2);

        Integer result3 = getGreatesCommon4(23, 92);
        System.out.println(result3);

        Integer result4 = getGreatesCommon4(80, 100);
        System.out.println(result4);

        Integer result5 = getGreatesCommon5(80, 100);
        System.out.println(result5);

        Integer result6 = getGreatesCommon6(52, 104);
        System.out.println(result6);

        Integer result7 = getGreatesCommon6(17,51);
        System.out.println(result7);
    }

    /**
     * 获取最大公约数  eg: 9 15 最大公约数 是 3  最大公倍数 45
     *
     * @param a
     * @param b
     * @return a  b
     * a/i == 0 && b/i ==0 公约数
     */
    public static Integer getGreatesCommon(int a, int b) {
        List<Integer> nums = new ArrayList<>();
        Integer max = getMin(a, b);
        for (Integer i = 1; i < max; i++) {
            if (a % i == 0 && b % i == 0) {
                nums.add(i);
            }
        }
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        Integer num = nums.get(nums.size() - 1);
        return num;
    }

    /**
     * getGreatesCommon 的升级版
     * 上面那个算法中需要算出所有的 公约数 ，然后在去找最大的那个
     * 优化之后，直接获取最大的公约数,获取到最大公约数之后就不再进行遍历了
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatesCommon1(int a, int b) {
        List<Integer> nums = new ArrayList<>();
        Integer min = getMin(a, b);
        for (Integer i = min - 1; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 思路： 递归 a%b = c  b%c =d 直至 取余为0
     * 这个算法是最高效的，但是还可以优化一下 if判断
     * 辗转相除法
     * if 可以使用三目运算符来简化代码结构
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatesCommon3(int a, int b) {
        Integer max = getMax(a, b);
        if (max == a) {
            a = a % b;
            if (a == 0) {
                return b;
            } else {
                return getGreatesCommon3(b, a);
            }
        } else {
            b = b % a;
            if (b == 0) {
                return a;
            } else {
                return getGreatesCommon3(a, b);
            }
        }
    }

    /**
     * 辗转相除法
     * getGreatesCommon3 的优，将if判断简化成三目运算，如果去公司 写getGreatesCommon3 这样的代码
     * 基本上可以直接滚蛋，一看就是没有经过重构的，一般人不重构都不会写那么垃圾的代码
     * 这个算法也是有问题的，如果bigNum 比较大的,求余的效率就比较低
     * 可以使用更相减损术
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatesCommon4(int a, int b) {
        int bigNum = a > b ? a : b;
        int smallNum = a < b ? a : b;
        if (bigNum % smallNum == 0) {
            return smallNum;
        }
        return getGreatesCommon4(bigNum % smallNum, smallNum);
    }

    /**
     * 更相减损术
     * 如果a b 中有一个数特别大，那使用上面的算法效率就有点低
     * 思路 ： a -b =c  c与 b 的最大公约数也是a 与 b的
     * 如果 a = 10000 b = 1 ，那就要递归 9999次
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatesCommon5(int a, int b) {
        if (a == b) {
            return a;
        }
        int bigNum = a > b ? a : b;
        int smallNum = a < b ? a : b;
        return getGreatesCommon5(bigNum - smallNum, smallNum);
    }

    /**
     * 更相减损术 与 辗转相除法 相结合使用
     * 移位运算
     * System.out.println(5&1); // 1
     * System.out.println(6&1); // 0
     * eg: 25 10  10 向左位移1位(位运算)  (只要有偶数就位移)  先理思路
     * 25 5  更相减损术
     * 20 5  左位移1位
     * 10 5  左位移1位
     * 5  5  结束
     * StackOverflowError 栈溢出
     * @param a
     * @param b
     * @return
     */
    public static Integer getGreatesCommon6(int a, int b) {
//        没有这个 if 判断 a==b ,就会一直执行，直至StackOverflowError ，栈内存满
        if(a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatesCommon6(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatesCommon6(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatesCommon6(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatesCommon6(big - small, small);
        }
    }

    /**
     * 获取最小值
     * 这个可以使用三目运算符解决
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getMin(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }

    /**
     * 获取最大值
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer getMax(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

}
