package com.xubo.string;

import org.junit.Test;

/**
 * @Author Druid_Xu
 * @Date 2020/12/7 上午 11:15
 * @Description
 */
public class IntegerTest {

    @Test
    public void testInteger() throws NumberFormatException {
        Integer i1 = Integer.valueOf(5);
        Integer i2 = Integer.valueOf(5);
        Integer i3 = null;
        Integer i4 = null;
        try {
            i3 = Integer.valueOf("abc");
            i4 = Integer.valueOf("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException == ");
//            e.printStackTrace();
        } finally {
            System.out.println(i3 == i4);  // true
            System.out.println("=====");
        }

        System.out.println(i1 == i2);
    }

}
