package com.xubo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * @Author Druid_Xu
 * @Date 2020/12/11 上午 09:45
 * @Description 正数反转
 * 如果只能存32位怎么办
 * 这里使用的是 int 类型定义输入的数据类型，如果输入的位数过大，就会出现 InputMismatchException
 */
public class IntReverse {
    public static void main(String[] args) {
        List<Integer> arrs = new ArrayList<>();
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        IntReverse intReverse = new IntReverse();
        List<Integer> ints = intReverse.intReverse(num, arrs, i);
        for (int number : ints) {
            System.out.print(number + " ");
        }
    }

    @Test
    public void sort() {
        System.out.println(7 / 10);
        System.out.println(7 % 10);
    }

    /**
     * 思路：  这里不考虑只能存储32位
     * 将整数的每一个数字存储到字节数组里面
     * 然后逆序输出取余，如果大于 10 继续递归，然后每次将个位存入数组，或者集合
     * 使用递归，对10进行除操作 判断是否大于10 ，大于就将取余后的结果存入数组
     *
     * @param num
     * @return
     */
    private List<Integer> intReverse(int num, List<Integer> tempArr, int i) {
        if (num / 10 > 0) {
            // 继续递归
            tempArr.add(num % 10);
            num = num / 10;
            intReverse(num,tempArr,i);
            return tempArr;
        } else {
            // 队num 除小于10 就直接将num存入tempArr 数组里面，然后return
            tempArr.add(num);
            return tempArr;
        }
    }
}
