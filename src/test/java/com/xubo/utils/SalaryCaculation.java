package com.xubo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author Druid_Xu
 * @Date 2020/12/2 下午 04:35
 * @Description
 * 4465
 * 40 20 1896  6361 6996
 * 48 12 1965  6430 7065
 *
 */
public class SalaryCaculation {
    /**
     * @Author: Xubo
     * @Date: 2020/8/1 17:55
     * 12 + 13 + 13  38
     * 22
     * 7 + 4 + 4
     */
    public static Map<String, Float> totalSalary = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input totalHour 、 weekHour 、baseSalary、overTimeSalary");
        int totalHour = sc.nextInt();
        int weekHour = sc.nextInt();
        int baseSalary = sc.nextInt();
        int overTimeSalary = sc.nextInt();
        SalaryCaculation salaryCaculation = new SalaryCaculation();
        totalSalary = salaryCaculation.caculate_S(baseSalary, overTimeSalary, totalHour, weekHour);
        Set<String> keySet = totalSalary.keySet();
        for (String str : keySet) {
            System.out.println(str + " " + totalSalary.get(str));
        }

    }

    private Map<String, Float> caculate_S(int baseSalary, int overTimeSalary, int totalHour, int weekHour) {
        float usualSalary = (float) (overTimeSalary / 174 * 1.5 * (totalHour - weekHour));
        float weekSalary = overTimeSalary / 174 * 2 * weekHour;
        float allSalary = baseSalary + usualSalary + weekSalary;
        totalSalary.put("usual_Salary", usualSalary);
        totalSalary.put("week_Salary", weekSalary);
        totalSalary.put("total_Salary", usualSalary + weekSalary);
        totalSalary.put("all_Salary", allSalary);
        return totalSalary;
    }
}
