package com.xubo.mall.controller.multithread;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xubo.mall.service.MultiThreadSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xubo
 * @Date 2021/6/20 9:42
 */
@RestController
@RequestMapping("/multi")
public class MultiThreadController {

    @Autowired
    MultiThreadSelectService multiThreadSelectService;

    @GetMapping("/thread/select")
    public PageInfo multiThreadSelect() {
        PageHelper.startPage(1, 30);
        List<Integer[]> list = new ArrayList<>();
        List<JSONObject> results = new ArrayList<>();
        Integer[] arr1 = {4,14,15,16,17,18};
        Integer[] arr2 = {27,30,31,32,33,34};
        Integer[] arr3 = {19,20,21,22,23,24};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        List<JSONObject> jsonObjects = multiThreadSelectService.selectScoreById(list);
        List<JSONObject> jsonObjects1 = multiThreadSelectService.selectScoreByIdWithThread(list);
        jsonObjects.addAll(jsonObjects1);
        return new PageInfo(jsonObjects);
    }


}
