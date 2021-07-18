package com.xubo.mall.service;

import java.util.List;

import com.xubo.mall.entity.Cos;
import com.xubo.mall.entity.Worker;

public interface WorkerService {

    public List<Worker> findAll();

    public Worker selectByPre(int workerids);

    public int insertCos(Worker worker);

    public int update(Worker worker);

    public int deleteByPre(int workerid);

    public List<Worker> findByIds(String[] ids);

}
