package com.xubo.Interview;

import java.util.Scanner;
//控制台输入年和月，输出该月的日历
public class CalendarPro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份（1900—2099）：");//1900年1月1日 星期一
        int year = input.nextInt();
        if (year >= 1900 && year <= 2099) {
            boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? true : false;
            System.out.print("请输入月份（1—12）：");
            int month = input.nextInt();
            if (month >= 1 && month <= 12) {
                int dayCount = 0;
                for (int i = 1900; i < year; i++) {//计算从1900年至指定年份的天数
                    boolean isLeap = ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) ? true : false;
                    dayCount += isLeap ? 366 : 365;
                }
                int maxDay = 0;
                for (int i = 1; i < month; i++) {
                    switch (i) {
                        case 2:
                            maxDay = isLeapYear ? 29 : 28;
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            maxDay = 30;
                            break;
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            maxDay = 31;
                    }
                    dayCount += maxDay;//此处共统计了指定年月距离1900年的天数
                }
                int weekDay = dayCount % 7;//总天数余7表示指定月前一天是星期几
                System.out.println(year + "年" + month + "月" + " 的日历如下：");
                System.out.println("日\t一\t二\t三\t四\t五\t六\t");
                for (int j = 1; j <= (weekDay + 1); j++) {//weekday+1表示当月第一天是星期几
                    System.out.print("\t");             //由于是星期日开头，需打印weekDay+1个\t
                }
                switch (month) {
                    case 2:
                        maxDay = isLeapYear ? 29 : 28;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        maxDay = 30;
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        maxDay = 31;
                }
                for (int j = 1; j <= maxDay; j++) {//打印日期数字，当
                    System.out.print(j + "\t");
                    if ((j + weekDay + 1) % 7 == 0) {//
                        System.out.println();
                    }
                }
            } else {
                System.out.println("月份输入错误");
            }
        } else {
            System.out.println("年份输入错误");
        }
    }
}