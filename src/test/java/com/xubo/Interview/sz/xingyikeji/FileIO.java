package com.xubo.Interview.sz.xingyikeji;

import com.xubo.mall.annotation.People;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @Author Xubo
 * @Date 2021/5/28 22:57
 * 对文件进行IO操作
 *
 */
public class FileIO {

    public static void main(String[] args) throws IOException {
        // FileInputStream 字节输入流
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("E:\\giteeproject\\DruidMall\\src\\test\\java\\com\\xubo\\Interview\\sz\\xingyikeji\\targetFile.txt")));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要写入txt的字符");
        String context = sc.nextLine();

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter((new FileOutputStream("E:\\giteeproject\\DruidMall\\src\\test\\java\\com\\xubo\\Interview\\sz\\xingyikeji\\targetFile.txt"))));

        String s;
//        while ((s = br.readLine()) != null) {
            bw.write(context);
            bw.newLine(); //换行
//        }
//        释放资源， 如果不写这两行，则b.txt中不会写入数据
        bw.close();

        // 读取文件中的内容
        String str;
        if((str = br.readLine()) != null) {
            System.out.println("txt中的内容: " + str);
        }
        br.close();
    }

    /**
     * 失败的案例，学习分析为什么会写成这个样子
     * @throws IOException
     */
    public static void fileTest1() throws IOException {
        File targetFile = new File("E:\\giteeproject\\DruidMall\\src\\test\\java\\com\\xubo\\Interview\\sz\\xingyikeji\\targetFile.txt");
        Scanner sc = new Scanner(System.in);
        String context = sc.nextLine();
        FileWriter fw = new FileWriter(targetFile);
        FileReader fr = new FileReader(context);
        int len = 0;
        int ch;
        byte[] bts = new byte[1024];
        if((ch = fr.read()) != -1) {
            fw.write((char) ch);
            fw.flush();
        }
        fw.close();
        fr.close();
    }

    @Test
    public void testString() {
        String str = "abcdcd";//abefcd
        String[] strs = str.split("c");
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }

    /**
     * 四千里数据
     * first day
     *
     *
     */
    @Test
    public void doFirst() {
        // first task 熟悉环境 、完成入职task



    }

    @Test
    public void longestPalindrome(String str) {


    }

}
