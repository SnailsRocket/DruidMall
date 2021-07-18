package com.xubo.mall.dao;

import com.xubo.mall.entity.MulChose;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xubo
 * @Date: 2020/10/11 10:52
 */
@Mapper
public interface MulChoseDao {

    public List<MulChose> findAll();

}
