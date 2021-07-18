package com.xubo.mall.controller;

import com.xubo.mall.entity.MulChose;
import com.xubo.mall.service.MulChoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Xubo
 * @Date: 2020/10/11 10:51
 */
@RestController
@RequestMapping("/mulchose")
@CrossOrigin(origins = {"http://localhost:63342",""})
public class MulChoseController {

    @Autowired
    MulChoseService mulChoseService;

    @GetMapping
    public List<MulChose> findAll() {

        return mulChoseService.findAll();
    }

}
