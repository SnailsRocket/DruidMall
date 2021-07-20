package com.xubo.mall.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.converters.bigdecimal.BigDecimalNumberConverter;
import lombok.*;

import java.math.BigDecimal;

/**
 * @Author xubo
 * @Date 2021/6/29 18:17
 * @Description easyexcel导出类
 * easyexcel  使用注解的方式可以将百分比转换成数字类型，
*       dataFormat对应的类型  参考官方文档  https://www.yuque.com/easyexcel/faq/gvywwb
 *      @ContentStyle(dataFormat=10)
 *      9 10 是显示百分比 百分比建议用9
 *      5 6 是人民币格式  ￥23,564
 *      4 是 49,999.00
 *      2 是 23564.00
 *      7 8 ￥49,999.00
 *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadData extends BaseExportData{

    /**
     * 有一个问题：继承BaseExportData BaseExportData 中的属性会在DownloadData属性的后面
     * 导致导出的excel格式乱了
     *
     * bug: 复杂头的导出会导致继承CellWriteHandler 这种方法失效 (list中获取的列数远远大于实际导出的列数) (列表中获取的是所有的value，有的属性有多个value)
     *
     */
    @ExcelProperty(value = "月花费", converter = BigDecimalNumberConverter.class)
//    @NumberFormat("$#.##")
    @ContentStyle(dataFormat = 1) // 5 是 货币 9 10 是百分比
    public BigDecimal monthlyCost;
//    public BigDecimal monthlyCost;

    @ExcelProperty(value = "年花费", converter = BigDecimalNumberConverter.class)
//    @NumberFormat("$#.##")
    @ContentStyle(dataFormat = 11)
    public BigDecimal yearCost;
//    public BigDecimal yearCost;

    @ExcelProperty(value = "总花费", converter = BigDecimalNumberConverter.class)
//    @NumberFormat("$#.##")
    @ContentStyle(dataFormat = 2)
    public BigDecimal totalCost;
//    public BigDecimal totalCost;

}
