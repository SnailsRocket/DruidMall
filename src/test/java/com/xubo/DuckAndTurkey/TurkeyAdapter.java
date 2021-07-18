package com.xubo.DuckAndTurkey;

import org.springframework.boot.SpringBootConfiguration;

/**
 * @Author Druid_Xu
 * @Date 2020/12/8 上午 10:57
 * @Description
 */
public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
