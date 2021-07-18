package com.xubo.lock;

/**
 * @Author Druid_Xu
 * @Date 2020/12/11 上午 08:29
 * @Description 正常运行不会输出main函数里面那个输出语句，打断点才可以进那个if 判断
 *
 */
public class VolatileTest {

    public static void main(String[] args) {
        Druid druid = new Druid();
        druid.start();
        for (; ; ) {
            synchronized (druid) {
                if (druid.isFlag()) {
                    System.out.println("fuck ...");
                }
            }
        }
    }
}

class Druid extends Thread {
    private volatile boolean flag = false;

    // 如果是 private 修饰的方法那么就不能被上面那个累调用
    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag is " + flag);
    }
}
