package com.xubo.mall.entity;

import com.xubo.mall.annotation.ExportProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author xubo
 * @Date 2021/7/13 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportStyleByAnnotation {

    @ExportProperty(value = "id")
    public Integer id;

    @ExportProperty(value = "花费", type = 1)
    public BigDecimal cost;

    @ExportProperty(value = "月花费", type = 1)
    public BigDecimal monthlyCost;

    @ExportProperty(value = "年花费", type = 1)
    public BigDecimal yearCost;

    @ExportProperty(value = "创建时间", type = 2)
    public Date createTime;

    @ExportProperty(value = "更新时间", type = 2)
    public Date updateTime;

    @ExportProperty(value = "达成率", type = 3)
    public String perscent;

    @ExportProperty(value = "达成率1", type = 3)
    public String perscent1;
}
