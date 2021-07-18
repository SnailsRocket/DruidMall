package com.xubo.Interview;


import com.xubo.mall.util.GetApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Druid
 * @Data:
 * @Description: 考察JVM内存区域
 *
 */
@RunWith(SpringRunner.class)
@Component
public class StringTest{

    /*public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "cs";
        swapString(str1, str2);
        System.out.println("str1=" + str1 + " str2=" + str2);

    }*/

    public static void swapString(String str1, String str2) {
        String temp = "";
        temp = str1;
        str1 = str2;
        str2 = temp;
        System.out.println("swap str1=" + str1 + " str2=" + str2);
    }

    @Test
    public void goSZ() {
        Random random = new Random();
        int result = random.nextInt(2);
        System.out.println("去深圳："+result);

    }


//    @Autowired
//    ApplicationContext applicationContext;


    @Test
    public void testBeanCount() throws InterruptedException {
        GetApplicationContext getApplicationContext = new GetApplicationContext();
//        TestBean testBean = stringTest.getApplicationContext().getBean(TestBean.class);
        ApplicationContext applicationContext = getApplicationContext.getApplicationContext();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                applicationContext.getBean(TestBean.class).add();
            }).start();
            countDownLatch.await();
            System.out.println(applicationContext.getBean(TestBean.class).get());
        }

    }


}

@Component
class TestBean {

    private int count = 0;

    public void add() {
        count++;
    }

    public int get() {
        return count;
    }

}
