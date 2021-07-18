package com.xubo.mall.util;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.junit.jupiter.api.Test;

/**
 * @Author xubo
 * @Date 2021/7/1 17:53
 */
public class TestUtils {

    @Test
    public void testEasyPoiExprt() {
        ExportParams exportParams = new ExportParams("标题1", "测试数据sheet");
        exportParams.setStyle(CostomExcelExportStyler.class);

    }

    @Test
    public void read() {

    }



}
