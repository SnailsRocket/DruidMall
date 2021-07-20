package com.xubo.mall.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.converters.bigdecimal.BigDecimalNumberConverter;
import com.alibaba.excel.annotation.write.style.ContentStyle;  // easyexcel 2.1.1里面没有需要升级版本到2.2.6
import com.alibaba.excel.converters.date.DateNumberConverter;
import com.alibaba.excel.converters.date.DateStringConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author xubo
 * @Date 2021/7/8 10:45
 * @Description 导出excel基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseExportData {

    @ExcelProperty({"Id"})
    public Integer id;
    @ExcelProperty({"许波"})
    public String name;
    @ExcelProperty({"数字"})
    public String password;
//    @ExcelProperty(value = {"日期"})
    @ExcelProperty(value = {"日期"},converter = DateNumberConverter.class)
//    @ExcelProperty(value = {"坐标", "日期"},converter = DateStringConverter.class) // 当日期是Date类型的时候这个格式转换就会失效
//    @DateTimeFormat("yyyy.MM.dd")
    @ContentStyle(dataFormat = 14)
    @ColumnWidth(30)
    public Date address;
    @ExcelProperty({"花费"})
    @ContentStyle(dataFormat = 3)
    public BigDecimal cost;

    // 使用注解的方式实现百分比数字化
    @ExcelProperty(value = "百分比")
//    @ExcelProperty(value = "百分比", converter = BigDecimalNumberConverter.class)
//    @NumberFormat("#.##%")
    @ContentStyle(dataFormat = 9)
    public BigDecimal perRate;

}
