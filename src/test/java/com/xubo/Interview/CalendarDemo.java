package com.xubo.Interview;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    public static void main(String[] args)
    {
        //模块化设计
        //自顶向下设计
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年和月份(1900-2099)：");
        int year = input.nextInt();
        System.out.print("请输入月份(1-12)：");
        int month = input.nextInt();

        if(isLeapYear(year)) {
            printCalendar(year,month);
        } else {
            System.out.println("输入年份超出范围，请重新输入！");
        }

    }


    public static void printCalendar(int year,int month)
    {
        printTitle(year,month);
        printBody(year,month);
    }

    public static void printTitle(int year,int month)
    {
        System.out.println(year + "年" + month + "月的日历如下");
        System.out.println("日  一  二  三  四  五  六");
    }

    public static void printBody(int year,int month)
    {
        int days = getDaysInMonth(year,month);
        int starDay = getStartDay(year,month);

        //完成打印

    }

    public static int getDaysInMonth(int year,int month)
    {
        int weekOfYear = Calendar.WEEK_OF_YEAR;
//        Calendar.getInstance()
        return 1;
    }

    public static  int getStartDay(int year,int month)
    {

        return 1;
    }

    public static boolean isLeapYear(int year)
    {
        boolean result = year > 1900 && year < 2099 ? true : false;
        return result;
    }
}
