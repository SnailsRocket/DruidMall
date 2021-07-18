package com.xubo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Druid_Xu
 * @Date 2020/11/19 上午 09:09
 * @Description
 */
public class BufferCopyFile {

    public static void main(String[] args) throws IOException {
//        封装源数据
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
//        封装目的地数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));

        /**
         * 将源文件中的数据 写入到目标文件中
         */
        char[] chars = new char[1024];
        int len = 0;
        while ((len = br.read(chars)) != -1) {
            bw.write(chars,0,len);
            bw.flush();
        }
//        关闭资源
        bw.close();
        br.close();

        String line = null;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();

    }

}
