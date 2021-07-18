package com.xubo.mall.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Xubo
 * @Date 2021/6/20 9:49
 */
@Mapper
public interface MultiThreadSelectDao {

    List<JSONObject> selectScoreById(@Param("scoreId") Integer[] ids);

}
