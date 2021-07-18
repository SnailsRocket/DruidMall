package com.xubo.mall.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.Getter;

/**
 * @Author xubo
 * @Date 2021/6/29 18:17
 */
@Data
public class DownloadData {

    @ExcelProperty({"姓名","Id"})
    public Integer id;
    @ExcelProperty({"姓名","许波"})
    public String name;
    @ExcelProperty({"密码","数字"})
    public String password;
    @ExcelProperty({"坐标","地址"})
    public String address;

    public DownloadData() {
    }

    public DownloadData(Integer id, String name, String password, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }


}
