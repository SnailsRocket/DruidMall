package com.xubo.test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @Author Druid_Xu
 * @Description 模拟键盘的KeyEvent事件
 * 注意keyPress之后需要 release，不释放就是组合键 win + x
 * @Date 2020/9/9 下午 01:50
 */
public class JavaKey extends JFrame {


    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        robot.delay(5000);
        int a = 0;
        boolean b = true;
        while (b) {

            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_X);
            a = Math.abs(random.nextInt()) % 100 + 50;
            robot.delay(a);

            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);

            /*robot.keyPress(KeyEvent.VK_Y);
            robot.keyRelease(KeyEvent.VK_Y);
            a = Math.abs(random.nextInt()) % 100 + 50;
            robot.delay(a);

            robot.keyPress(KeyEvent.VK_B);
            robot.keyRelease(KeyEvent.VK_B);
            a = Math.abs(random.nextInt()) % 100 + 50;
            robot.delay(a);

            robot.keyPress(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_Q);
            a = Math.abs(random.nextInt()) % 100 + 50;
            robot.delay(a);

            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);*/

            a = Math.abs(random.nextInt()) % 2000 + 1000;
            System.out.println(a);
            robot.delay(a);
            b = false;
        }
    }


}
