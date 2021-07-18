package com.xubo.mall.service.impl;

import com.xubo.mall.dao.MulChoseDao;
import com.xubo.mall.entity.MulChose;
import com.xubo.mall.service.MulChoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xubo
 * @Date: 2020/10/11 10:55
 */
@Service
public class MulChoseServiceImpl implements MulChoseService {

    @Autowired
    MulChoseDao mulChoseDao;

    @Override
    public List<MulChose> findAll() {
        return mulChoseDao.findAll();
    }
}
