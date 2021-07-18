package com.xubo.string;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * @Author Druid_Xu
 * @Date 2020/12/7 上午 10:45
 * @Description
 */
public class StringUtilsPro {

    @Test
    public void test() {
        System.out.println("judgeNull");
        boolean abc = judgeNull("abc");
        System.out.println("judgeNull");
        boolean b = judgeNull("");
        System.out.println("judgeNull");
        boolean b1 = judgeNull(null);
        System.out.println("judgeNull1");
        boolean b2 = judgeNull1("");
        System.out.println("judgeNull2");
        judgeNull2("str");
        System.out.println("judgeNull2");
        judgeNull2(null);
        System.out.println("judgeNull2");
        judgeNull2("");
    }


    public boolean judgeNull(String str) {
        if(str == null || "".equals(str)) {
            System.out.println("str is null ");
            return false;
        }
        char[] chars = str.toCharArray();
        if(chars.length > 0) {
            System.out.println("str is a String");
            return true;
        }
        return false;
    }

    public boolean judgeNull1(String str) {
        if(Strings.isNullOrEmpty(str)) {
            System.out.println("str is nulls");
            return false;
        }
        return true;
    }

    public boolean judgeNull2(String str) {
        if(str == null || str.isEmpty()) {
            System.out.println("直接使用String底层源码，false");
            return false;
        }
        System.out.println("true，str is not null");
        return true;
    }
}
