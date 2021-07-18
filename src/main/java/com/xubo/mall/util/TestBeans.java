package com.xubo.mall.util;

import org.springframework.stereotype.Component;

/**
 * @Author Xubo
 * @Date 2021/5/20 22:47
 */
@Component
public class TestBeans {

    private int count = 0;

    public void add() {
        count++;
    }

    public int get() {
        return count;
    }

}
