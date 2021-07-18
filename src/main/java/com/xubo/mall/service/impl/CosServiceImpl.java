package com.xubo.mall.service.impl;

import com.xubo.mall.dao.CosDao;
import com.xubo.mall.entity.Cos;
import com.xubo.mall.service.CosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/2 上午 08:49
 */
@Service
public class CosServiceImpl implements CosService {

    @Autowired
    public CosDao cosDao;

    @Override
    public List<Cos> findAll() {
        List<Cos> cosList = cosDao.findAll();
        return cosList;
    }

    @Override
    public Cos selectByPre(int cosprocessid) {
        Cos cos = cosDao.selectByPre(cosprocessid);
        return cos;
    }

    @Override
    public int insertCos(Cos cos) {
        int i = cosDao.insertCos(cos);
        return i;
    }

    @Override
    public int update(Cos cos) {
        int update = cosDao.update(cos);
        return update;
    }

    @Override
    public int deleteByPre(int cosprecessid) {
        int i = cosDao.deleteByPre(cosprecessid);
        return i;
    }
}
