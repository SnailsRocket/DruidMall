package com.xubo.mall.config;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.xubo.mall.util.CommonDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author xubo
 * @Date 2021/7/7 14:19
 * 还是有问题
 */
@Slf4j
public class RowWriteHandler implements CellWriteHandler {

    /**
     * 列名存储列表 数据量超过500时，会刷新缓存，表头会丢失，所以要存一下，以便查找
     */
    private static final List<String> COLUMNS = new ArrayList<>();

    /**
     * 时间+日期样式存储 一个excel的sheet页，最多可以创建64000个样式，频繁创建会倒是程序报错
     */
    private CellStyle dateTimeStyle;
    /**
     * 时间样式存储 一个excel的sheet页，最多可以创建64000个样式，频繁创建会倒是程序报错
     */
    private CellStyle dateStyle;
    /**
     * 金额样式存储 一个excel的sheet页，最多可以创建64000个样式，频繁创建会倒是程序报错 数值类型有问题的，主要原因是 dto 里定义的是 String 类型导致，如果是
     * double 与 Integer 类型则正常导出不需要传入处理
     */
    private CellStyle numberStyle;

    /**
     * 需要处理日期列名
     */
    private Object dateColumns;
    /**
     * 需要处理日期含时间的列名
     */
    private Object dateTimeColumns;
    /**
     * 需要处理数值的列名
     */
    private Object numberColumns;

    /**
     * 列宽时需要乘256
     */
    private Integer widthCommon = 256;


    private HashMap<Integer, List<Integer>> map;

    String[] moneyColumns = {"月花费", "年花费", "总花费"};

    String[] dataColumns = {"日期"};


    private static List<String> columnsList = new ArrayList<>();


    /*public RowWriteHandler(HashMap<Integer, List<Integer>> map, Short colorIndex) {
        this.map = map;
    }*/
    public RowWriteHandler() {
            this.map = map;
        }

    /**
     * 初始化参数 注意：数值类型传入前提是列dto里数值类型的字段定义的是字符串类型（如果定义的是double或intger则不需要转换）
     *
     * @param map 传入需要特殊处理的三个类型 dateColumns、dateTimeColumns、numberColumns
     */
    public RowWriteHandler(Map<String, Object> map) {
        columnsList.clear();
        dateTimeStyle = null;
        dateStyle = null;
        numberStyle = null;

        this.dateColumns = map.get("dateColumns");
        this.dateTimeColumns = map.get("dateTimeColumns");
        this.numberColumns = map.get("numberColumns");
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean isHead) {

    }

    /**
     * @param writeSheetHolder
     * @param writeTableHolder
     * @param cellData
     * @param cell
     * @param head
     * @param integer
     * @param aBoolean
     */
    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    /**
     * 这个方法内才是对cell进行样式格式化操作
     *
     * @param writeSheetHolder
     * @param writeTableHolder
     * @param list
     * @param cell
     * @param head
     * @param integer
     * @param isHead
     */
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                 List<CellData> list, Cell cell, Head head, Integer integer, Boolean isHead) {

        // 列宽
        int width = 20;

        if (isHead != null && isHead) {
            //获取表头，存储起来，否则但数据超过500时会 flush 导致列名丢失报错
            COLUMNS.add(cell.getStringCellValue());
        } else if (isHead != null) {
            // 当前列名
            String columnName = COLUMNS.get(cell.getColumnIndex());

            //是否是日期加时间
            /*boolean dateTimeFlag = StringUtils.isNotBlank(Arrays.stream(
                    (String[]) dateTimeColumns).filter(item -> item.equals(columnName)).findAny()
                    .orElse(""));*/
            //是否是日期
            boolean dateFlag = StringUtils.isNotBlank(
                    Arrays.stream((String[]) dataColumns).filter(item -> item.equals(columnName))
                            .findAny().orElse(""));
            //是否是数值（前提：要处理的列dto里得是字符串类型）
            boolean numberColumnFlag = StringUtils.isNotBlank(
                    Arrays.stream((String[]) moneyColumns).filter(item -> item.equals(columnName))
                            .findAny().orElse(""));

            // 日期类标识
//            boolean dateFlags = dateTimeFlag || dateFlag;
            boolean dateFlags = numberColumnFlag || dateFlag;

            if (dateFlags || numberColumnFlag) {
                Workbook wk = writeSheetHolder.getSheet().getWorkbook();

                String stringCellValue = null;
                try {
                    stringCellValue = cell.getStringCellValue();
                } catch (Exception e) {
                    // double或integer 类型数值不需要转换单元格格式，前端不要传入，后台直接去掉转换解决！
                    dateFlags = false;
                }
                try {
                    CreationHelper createHelper = wk.getCreationHelper();
                    if (StringUtils.isNotBlank(stringCellValue) && dateFlags) {
                        String[] patterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};
                        Date date = DateUtils.parseDate(stringCellValue, patterns);
//                        if (dateTimeFlag) {
                        if (false) {
                            //订单生成日期
                            if (dateTimeStyle == null) {
                                dateTimeStyle = wk.createCellStyle();
                            }
                            dateTimeStyle.setDataFormat(createHelper.createDataFormat()
                                    .getFormat("yyyy/mm/dd hh:mm:ss"));
                            cell.setCellStyle(dateTimeStyle);
                        } else {
                            //其他日期列
                            width = 15;
                            if (dateStyle == null) {
                                dateStyle = wk.createCellStyle();
                            }
                            dateStyle.setDataFormat(
                                    createHelper.createDataFormat().getFormat("yyyy/mm/dd"));
                            cell.setCellStyle(dateStyle);
                        }

                        cell.setCellValue(date);
                    } else if (StringUtils.isNotBlank(stringCellValue) && numberColumnFlag && isNumber(stringCellValue)) {
                        //其他数值列（数值类型有问题的，主要原因是 dto 里定义的是 String 类型导致，如果是 double 与 Integer 类型则正常导出不需要传入处理）
                        width = 11;
                        double money = Double.parseDouble(stringCellValue);
                        if (numberStyle == null) {
                            numberStyle = wk.createCellStyle();
                        }
                        numberStyle
                                .setDataFormat(createHelper.createDataFormat().getFormat("0.00"));
                        cell.setCellStyle(numberStyle);
                        cell.setCellValue(money);
                    }

                    // 统一处理列宽
                    int columnWidth = writeSheetHolder.getSheet()
                            .getColumnWidth(cell.getColumnIndex());
                    if (columnWidth < width * widthCommon) {
                        writeSheetHolder.getSheet()
                                .setColumnWidth(cell.getColumnIndex(), width * widthCommon);
                    }
                } catch (ParseException e) {
                    log.info("导出信息时出现错误：值：{},行：{},列：{}", stringCellValue,
                            cell.getRow().getRowNum(), cell.getColumnIndex());
                    cell.setCellValue("");
                }
            }
        }
    }


    /**
     * 判断一个字符串是否是数字。
     *
     * @param value
     * @return
     */
    public static boolean isNumber(String value) {
        String regex = "^-?\\d+(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).matches();
    }


}
