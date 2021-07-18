package com.xubo.test;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/9 下午 02:19
 */
public class LogicCalculate {

    public static void main(String[] args) {

        LogicCalculate lc = new LogicCalculate();
        boolean b = lc.logicCalcculate_all(true, true);
        System.out.println(b);

    }

    private boolean logicCalcculate_all(boolean b1,boolean b2) {
        if(b1 == true && b2 == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean logicCalcculate_not_all(boolean b1,boolean b2) {
        if(b1 == true & b2 == true) {
            return false;
        } else {
            return true;
        }
    }
}
