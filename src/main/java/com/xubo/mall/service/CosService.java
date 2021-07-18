package com.xubo.mall.service;

import com.xubo.mall.entity.Cos;

import java.util.List;

public interface CosService {

    public List<Cos> findAll();

    public Cos selectByPre(int cosprocessid);

    public int insertCos(Cos cos);

    public int update(Cos cos);

    public int deleteByPre(int cosprecessid);



}
