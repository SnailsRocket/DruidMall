package com.xubo.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.dao.MultiThreadSelectDao;
import com.xubo.mall.service.MultiThreadSelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/6/20 9:48
 */
@Service
@Slf4j
public class MultiThreadSelectServiceImpl implements MultiThreadSelectService {

    @Autowired
    MultiThreadSelectDao multiThreadSelectDao;

    @Override
    public List<JSONObject> selectScoreById(List<Integer[]> idList) {
        List<JSONObject> res = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("mm ss SSS");
        long startTime = System.currentTimeMillis();
        List<JSONObject> res1 = multiThreadSelectDao.selectScoreById(idList.get(0));
        res.addAll(res1);
        long res1EndsTime = System.currentTimeMillis();
        List<JSONObject> res2 = multiThreadSelectDao.selectScoreById(idList.get(1));
        res.addAll(res2);
        List<JSONObject> res3 = multiThreadSelectDao.selectScoreById(idList.get(2));
        res.addAll(res3);
        long endTime = System.currentTimeMillis();
        System.out.println("res1 cost time " + sdf.format(res1EndsTime-startTime));
        System.out.println("res cost time " + sdf.format(endTime-startTime));
        return res;
    }

    @Override
    public List<JSONObject> selectScoreByIdWithThread(List<Integer[]> idList) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm ss SSS");
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<CompletableFuture<List<JSONObject>>> resList = idList.stream()
                .map(inputParam -> CompletableFuture.supplyAsync(
                () -> multiThreadSelectDao.selectScoreById(inputParam), executorService))
                .collect(Collectors.toList());
        List<List<JSONObject>> joinList = resList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        List<JSONObject> result = joinList.stream().flatMap(inner -> inner.stream()).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("selectScoreByIdWithThread  res cost time " + sdf.format(endTime-startTime));
        return result;
    }
}
