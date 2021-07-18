package com.xubo.mall.util;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.ss.usermodel.*;

/**
 * @Author xubo
 * @Date 2021/7/1 16:52
 */
public class CostomExcelExportStyler extends ExcelExportStylerDefaultImpl {

    // EXCEL_COVERT_MONEY 是自己定义的标识符
    @Excel(name = "测试数值类型", dict = "$")
    private CellStyle numberCellStyle;

    public CostomExcelExportStyler(Workbook workbook) {
        super(workbook);
        createNumberCellStyler();
    }

    private void createNumberCellStyler() {
        numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setAlignment(HorizontalAlignment.CENTER);
        numberCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        numberCellStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("#,##0.00"));
        numberCellStyle.setWrapText(true);
    }

    @Override
    public CellStyle getStyles(boolean noneStyler, ExcelExportEntity entity) {
        // 判断是否需要格式化        
        if (entity != null && "$".equals(entity.getDict())) {
            return numberCellStyle;
        }
        return super.getStyles(noneStyler, entity);
    }
//    ExportParams exportParams = new ExportParams("标题", "sheetName");
    // 设置样式
//    exportParams.setStyle(CostomExcelExportStyler);

}
