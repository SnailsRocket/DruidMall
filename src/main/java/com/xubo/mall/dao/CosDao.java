package com.xubo.mall.dao;

import com.xubo.mall.entity.Cos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface CosDao {

    public List<Cos> findAll();

    public Cos selectByPre(int cosprocessid);

    public int insertCos(Cos cos);

    public int update(Cos cos);

    public int deleteByPre(int cosprecessid);



}
