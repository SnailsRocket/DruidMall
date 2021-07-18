package com.xubo.easyexcel;

import org.slf4j.Logger;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.metadata.ReadSheet;


/**
 * @Author Druid_Xu
 * @Date 2020/11/30 上午 08:54
 * @Description
 */
public class EasyExcelDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelDemo.class);

    /**
     * 最简单的读
     * 1.创建excel对应的实体对象 参照 DemoDate
     * 2.由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器， 参照DemoDateListener
     * 3.直接读即可
     */
    @Test
    public void simpleRead() {
        // 有个写法很重要 DemoDateListener 不能被Spring管理，所以每次读取excel都需要new，然后；里面用到Spring可以构造方法传进去
        // 写法1
        DemoDataListener demoDataListener = new DemoDataListener();
        EasyExcel.read("D:\\a.xlsx", EasyExcelDemo.class, demoDataListener).sheet().build();
        for (int i = 0; i < demoDataListener.list.size(); i++) {
            System.out.println(demoDataListener.list.get(i));
        }


    }


}
