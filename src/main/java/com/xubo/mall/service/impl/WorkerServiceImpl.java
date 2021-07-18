package com.xubo.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xubo.mall.dao.WorkerDao;
import com.xubo.mall.entity.Worker;
import com.xubo.mall.service.WorkerService;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/2 上午 08:49
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    public WorkerDao workerDao;


    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public Worker selectByPre(int workerids) {
        return null;
    }

    @Override
    public int insertCos(Worker worker) {
        return 0;
    }

    @Override
    public int update(Worker worker) {
        return 0;
    }

    @Override
    public int deleteByPre(int workerid) {
        return 0;
    }

    @Override
    public List<Worker> findByIds(String[] ids) {
        return workerDao.findByIds(ids);
    }
}
