package com.xubo.mall.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xubo
 * @Date 2021/7/9 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportDataWithStyle {

    @ExcelProperty(value = "编号")
    private Integer id;

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "月花费")
    private String monthlyCost;

    @ExcelProperty(value = "月花费")
    private String yearCost;

    @ExcelProperty(value = "总花费")
    private String totalCost;

}
