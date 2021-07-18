package com.xubo.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.entity.Worker;
import com.xubo.mall.service.WorkerService;

/**
 * @Author Druid_Xu
 * @Date 2020/12/22 上午 10:29
 * @Description
 * request  {ids:[12,13,14]}
 * response {ids:[12,13,14],names:["张三","李四","王五"]}
 *
 */
@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @PostMapping("/worker/findByIds")
    public List<Worker> findWorker(@RequestBody String ids) {
        JSONObject jsonObject = JSONObject.parseObject(ids);
        String idss = (String)jsonObject.get("ids");
        String[] str_ids = StringUtils.commaDelimitedListToStringArray(idss);
        List<Worker> result = workerService.findByIds(str_ids);
        return result;
    }

    @PostMapping("/worker/findByIdss")
    public List<Worker> findWokerByIds(@RequestBody String ids) {
        JSONObject jsonObject = JSONObject.parseObject(ids);
        JSONArray idss = jsonObject.getJSONArray("ids");
        System.out.println();
        String[] strs = (String[]) idss.toArray();
        List<Worker> result = workerService.findByIds(strs);
        return result;
    }

}
