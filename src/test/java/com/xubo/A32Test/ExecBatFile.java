package com.xubo.A32Test;

import java.io.IOException;

/**
 * @Author Druid_Xu
 * @Date 2020/12/24 下午 02:05
 * @Description
 */
public class ExecBatFile {
    public static void main(String[] args) {
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("cmd.exe /c" + "start /min D:\\xubo\\test.bat");
            Thread.sleep(5000);
            System.out.println("success");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("error");
        }

    }
}
