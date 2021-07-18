package com.xubo.mall.controller.fourkmiles;

import com.xubo.mall.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

/**
 * @Author Xubo
 * @Date 2021/6/22 15:20
 */
@RestController
@Slf4j
@RequestMapping("/test/async")
public class TestAsyncController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/list")
    public ApiResult testAsync() {
        SimpleDateFormat sdf = new SimpleDateFormat("ss 秒 SSS 毫秒");
        long startTime = System.currentTimeMillis();
        applicationContext.getBean(TestAsyncController.class).doAsyncMethod();
        applicationContext.getBean(TestAsyncController.class).doAsyncMethod();
        long endTime = System.currentTimeMillis();
        System.out.println(sdf.format(endTime-startTime));
        log.debug("执行结束！");
        return new ApiResult();
    }



    @Async
    public void doAsyncMethod() {
        try {
            Thread.sleep(5000);
            log.debug("异步方法执行了。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
