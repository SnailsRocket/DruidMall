package com.xubo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Druid_Xu
 * @Description  初识反射
 * @Date 2020/9/17 上午 08:18
 *
 */
public class TragetObject {

    public static void main(String[] args) throws ClassNotFoundException {
//   java中通过反射获取对象的三种常见方式
//        Class classUtils = Class.forName("com.alibaba.excel.util.ClassUtils");
//
//        Class tragetObject =  TragetObject.class;
//
//        Class e = null; //这个e对象需要先实例化才能getClass()
//        Class tragetObject1 = e.getClass();

        Map<String,Object> map = new HashMap<String,Object>(2) {{
            put("xubo",1);
            put("Druid",2);
        }};

//        Set set = map.entrySet();
        Set<String> strings = map.keySet();
        for (String o : strings) {
            System.out.println(o + " " + map.get(o));
            System.out.println(o);
        }

        String Is_location = "AKBHDMLOSSS";
        if( Is_location.indexOf("KB") > -1 ) {
            System.out.println("KB在字符串里面");
        } else if(Is_location.indexOf("D") > -1) {
            System.out.println("D在字符串里面");
        } else if(Is_location.indexOf("SSS") > -1) {
            System.out.println("SSS在字符串里面");
        } else {
            System.out.println("KB，D，SSS都不在字符串里面");
        }



    }
    
}
