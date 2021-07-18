package com.xubo.mall.controller.fourkmiles;

import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.common.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/6/13 16:28
 */
@RestController
@RequestMapping("/test")
public class TestResponseController {

    @GetMapping("/response")
    public ApiResult testResponse() {
        List<JSONObject> list = new ArrayList<>();
        list.add(new JSONObject().fluentPut("siteId",14).fluentPut("siteName", "日本").fluentPut("userName", "test2").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName","Guangzhou Issyzone"));
        list.add(new JSONObject().fluentPut("siteId",3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "1231231312311").fluentPut("advertiserName","Issyzone"));
        list.add(new JSONObject().fluentPut("siteId",4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "3434344343342").fluentPut("advertiserName","bv"));
        list.add(new JSONObject().fluentPut("siteId",3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "3434232323232").fluentPut("advertiserName","yzone"));
        list.add(new JSONObject().fluentPut("siteId",4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "157asd558asd2").fluentPut("advertiserName","Guangzhne"));
        list.add(new JSONObject().fluentPut("siteId",4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "ascx461279e82").fluentPut("advertiserName","Guangzzone"));
        list.add(new JSONObject().fluentPut("siteId",3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "2323232323fef").fluentPut("advertiserName","Guazone"));
        list.add(new JSONObject().fluentPut("siteId",3).fluentPut("siteName", "美国").fluentPut("userName", "test3").fluentPut("advertiserId", "9444562260603").fluentPut("advertiserName","Guangzhou Issyzone"));
        list.add(new JSONObject().fluentPut("siteId",14).fluentPut("siteName", "日本").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260621").fluentPut("advertiserName","Guasyzone"));
        list.add(new JSONObject().fluentPut("siteId",4).fluentPut("siteName", "加拿大").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260698").fluentPut("advertiserName","Gsyzone"));
        list.add(new JSONObject().fluentPut("siteId",4).fluentPut("siteName", "加拿大").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260667").fluentPut("advertiserName","Guangzhoe"));
        list.add(new JSONObject().fluentPut("siteId",3).fluentPut("siteName", "美国").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName","Guanho"));
        list.add(new JSONObject().fluentPut("siteId",14).fluentPut("siteName", "日本").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName","Gue"));


        List<JSONObject> result = new ArrayList<>();
        Map<Object, Map<String,List<JSONObject>>> resultMap =  new HashMap<>();
        resultMap = list.stream().collect(
                Collectors.groupingBy(
                        e -> e.getString("userName") ,
                        Collectors.groupingBy(
                                o -> o.getString("siteId"))
                )
        );
        System.out.println(resultMap.size());
        return new ApiResult(0,null,resultMap);

    }

}
