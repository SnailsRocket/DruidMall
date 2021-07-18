package com.xubo.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xubo.mall.entity.Cos;
import com.xubo.mall.entity.Worker;

@Mapper
//@Repository
public interface WorkerDao {

    public List<Worker> findAll();

    public Worker selectByPre(int workerId);

    public int insertCos(Worker worker);

    public int update(Worker worker);

    public int deleteByPre(int workerId);

    public List<Worker> findByIds(String[] ids);

}
