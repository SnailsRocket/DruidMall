package com.xubo.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Druid_Xu
 * @Date 2020/10/16 上午 09:32
 * @Description 获取当前 windows 的 用户名称
 * 获取系统用户名 ： 这个涉及到安全问题，只有ie可以获取
 *  前端js、vue等框架不能直接获取系统用户名，js仅可以在ie浏览器下获取系统用户名，
 *  还有一种方案就是通过设置IIS服务器，将用户信息写入到浏览器里面，但是运行容器就是IIS
 *  服务端代码可以获取
 * nodejs  os模块 获取系统用户名
 *  os.userInfo();
 *
 */
public class GetSystemUserName {

    public static void main(String[] args) {

        getSystemUsername();

    }

    private static void getSystemUsername() {
        String userName = System.getProperty("user.name");
        System.out.println(userName);
    }
}
