package com.xubo.mall.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Author Xubo
 * @Date 2021/6/20 9:48
 */
public interface MultiThreadSelectService {

    List<JSONObject> selectScoreById(List<Integer[]> idList);

    List<JSONObject> selectScoreByIdWithThread(List<Integer[]> idList);

}
