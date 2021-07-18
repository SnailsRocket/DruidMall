package com.xubo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 下午 01:37
 * @Description 拆分红包
 * 红包算法
 */
public class DivideRedPackage {

    public static List<Integer> divideRed(int totalAmount, int totalPeople) {
        List<Integer> amountList = new ArrayList<Integer>();
        int restAmount = totalAmount;
        int restPeople = totalPeople;
        Random random = new Random();
        for (int i = 0; i < totalPeople - 1; i++) {
            int amount = random.nextInt(restAmount / restPeople * 2 - 1) + 1;
            restAmount -= amount;
            restPeople--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> divideRed = divideRed(50, 10);
        for (Integer money : divideRed) {
            System.out.println("红包金额： " + money);
        }
    }
}
