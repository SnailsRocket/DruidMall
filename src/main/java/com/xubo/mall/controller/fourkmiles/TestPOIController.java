package com.xubo.mall.controller.fourkmiles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xubo
 * @Date 2021/7/8 10:41
 */
@RequestMapping("/test")
@RestController
public class TestPOIController {

    @PostMapping("/poi")
    public void exportExcelByPOI() {

    }


}
