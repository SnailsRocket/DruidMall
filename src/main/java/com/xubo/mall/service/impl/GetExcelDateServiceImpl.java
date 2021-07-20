package com.xubo.mall.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.config.RowWriteHandler;
import com.xubo.mall.entity.DownloadData;
import com.xubo.mall.entity.DownloadDateEnum;
import com.xubo.mall.entity.ExportDataWithStyle;
import com.xubo.mall.entity.ExportStyleByAnnotation;
import com.xubo.mall.handler.CellStyleHandler;
import com.xubo.mall.service.GetExcelDateService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date 2021/6/30 14:49
 * Easyexcel 使用自定义导出excel,无法使使用自定义的人列，(所以无法格式化)
 * 自定义实体类和货币格式化只能选一个
 * 实现CellWriteHandler 这种方式还是没有实现
 * easyexcel 动态修改Excel 表头中的内容   https://zhuanlan.zhihu.com/p/347768675
 */
@Service
public class GetExcelDateServiceImpl implements GetExcelDateService {

    /**
     * easyexcel
     *
     * @param response
     * @param dto
     * @param selectMenu
     *
     * RepayExcelDto aa = new RepayExcelDto();
     *   aa.setOverdueDays(11);
     *   List<RepayExcelDto> filterRepayExcelDtos = Arrays.asList(aa);
     *   Field overdueDays = RepayExcelDto.class.getDeclaredField("overdueDays");
     *   overdueDays.setAccessible(true);
     *   ExcelProperty excel = overdueDays.getAnnotation(ExcelProperty.class);
     *   InvocationHandler excelH = Proxy.getInvocationHandler(excel);
     *   Field excelF = excelH.getClass().getDeclaredField("memberValues");
     *   excelF.setAccessible(true);
     *   Map excelValues = (Map) excelF.get(excelH);
     *   Object excelOS = excelValues.get("value");
     *   excelValues.put("value", new String[]{"修改后的值"});
     *
     *   EasyExcel.write(new File("D:\\xxx\\hebingrong\\Desktop\\aa.xlsx"), RepayExcelDto.class)
     *   .excelType(ExcelTypeEnum.XLSX).sheet("detail").doWrite(filterRepayExcelDtos);
     *
     */
    @Override
    public void exportTestExcel(HttpServletResponse response, JSONObject dto, List<Integer> selectMenu) {
        List<DownloadDateEnum> downloadDateEnums = new ArrayList<>();
        selectMenu.stream().forEach(e -> downloadDateEnums.addAll(DownloadDateEnum.getDownloadDateEnumByRange(Integer.valueOf(e))));
        try (ServletOutputStream outputStream = response.getOutputStream()) {

//            response.setContentType("application/vnd.ms-excel");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String year = dto.getString("year");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode( year + "测试下载excel", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//            EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(outputStream);
//            EasyExcelFactory.getWriter(outputStream, ExcelTypeEnum.XLSX, true).write(list,new Sheet(1,0, DownloadData.class)).finish();
//            EasyExcel.write(outputStream,DownloadData.class).sheet("测试数据sheet").doWrite(list);
//            EasyExcel.write(fileName).head(fillHead(downloadDateEnums)).sheet("测试sheet").doWrite(null);
            List<DownloadData> dataList = fillDataToExcel();
            List<String> headNameList = getHeadNameList();
            // 通过反射，在运行时修改ExcelProperty 注解中的内容
            setHeadSelf();

            EasyExcel.write(response.getOutputStream(),DownloadData.class)
//                    .registerWriteHandler(new RowWriteHandler())
                    .sheet("测试excel").doWrite(dataList);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导出文件异常");
        }
    }

    /**
     *  通过反射，在运行时修改注解中的内容
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void setHeadSelf() throws NoSuchFieldException, IllegalAccessException {
        Field monthlyCost = DownloadData.class.getDeclaredField("monthlyCost");
        monthlyCost.setAccessible(true);
        ExcelProperty annotation = monthlyCost.getAnnotation(ExcelProperty.class);
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        Field field = invocationHandler.getClass().getDeclaredField("memberValues");
        field.setAccessible(true);
        Map excelValue = (Map)field.get(invocationHandler);
        Object excelOS = excelValue.get("value");
        excelValue.put("value",new String[]{"更改excel导出头"});
    }

    @Override
    public void testExcelWithAnnotation(HttpServletResponse response, JSONObject dto) {
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("测试自定义注解", "utf-8");
            response.setHeader("Content-disposition","attachment;filename*=utf-8''" + fileName + ".xlsx");
            List<ExportStyleByAnnotation> dataList = fillDataToAnnotation();
            EasyExcel.write(response.getOutputStream(),ExportStyleByAnnotation.class).sheet("自定义注解")
                    .doWrite(dataList);

            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("导出文件异常!");
        }
    }

    @Override
    public void exportTestExcelAndImplCellWriteHandler(HttpServletResponse response, JSONObject dto) {
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("2021style", "utf-8");

            response.setHeader("Content-disposition","attachment;filename*=utf-8''"+ fileName + ".xlsx");

            Map<String, Object> headMap = new HashMap<>(3);
            headMap.put("dateTimeColumns",new String[]{"月花费","月花费","总花费"});
            headMap.put("dateColumns",new String[]{});
            headMap.put("numberColumns",new String[]{});
            List<ExportDataWithStyle> dataList = fillDataToExcelStyle();
            EasyExcel.write(response.getOutputStream(),ExportDataWithStyle.class)
                    .registerWriteHandler(new RowWriteHandler(headMap))
                    .sheet("测试CellWriteHandler")
                    .doWrite(dataList);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("导出文件异常");
        }

    }

    /**
     * 使用easyexcel实现自定义head以及金额、日期、百分比的格式化转换
     * @param response
     * @param dto
     */
    @Override
    public void exportExcelCustomHead(HttpServletResponse response, JSONObject dto) {
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("自定义表头", "utf-8");
            response.setHeader("Content-disposition","attachment;filename*=utf-8''" + fileName + ".xlsx");
            List<List<String>> headList = fillCostomHead();
            List<List<Object>> dateList = fillCostomDate();
            Map<String, Object> map = new HashMap<>();
            EasyExcel.write(response.getOutputStream()).head(headList)
//                    .registerWriteHandler(new CellStyleHandler(map))
                    .sheet("sheet1").doWrite(dateList);

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("导出文件异常!");
        }

    }

    public List<List<String>> fillCostomHead() {
        List<List<String>> headList = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("id");
        List<String> head1 = new ArrayList<>();
        head1.add("花费");
        List<String> head2 = new ArrayList<>();
        head2.add("月花费");
        List<String> head3 = new ArrayList<>();
        head3.add("日期");
        List<String> head4 = new ArrayList<>();
        head4.add("总花费");
        List<String> head5 = new ArrayList<>();
        head5.add("百分比");
        List<String> head6 = new ArrayList<>();
        head6.add("年花费");
        headList.add(head0);
        headList.add(head1);
        headList.add(head2);
        headList.add(head3);
        headList.add(head4);
        headList.add(head5);
        headList.add(head6);
        return headList;
    }

    /**
     * easyexcel 自定义填充数据，
     *  excel中的列的顺序是按照加入集合的顺序
     * 自定义的导出 无法使用注解也无法使用拦截器(重写CellWriteHandler)
     * @return
     */
    public List<List<Object>> fillCostomDate() {
        List<List<Object>> dateList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> cellList = new ArrayList<>();
            cellList.add(1);
            cellList.add(new BigDecimal("5436.4567"));
            cellList.add(new BigDecimal("9632.23"));
            cellList.add(new Date());
            cellList.add(new BigDecimal("5478.45"));
            cellList.add(new BigDecimal("58764"));
            cellList.add("67.78%");
            dateList.add(cellList);
        }

        return dateList;
    }

    public List<ExportDataWithStyle> fillDataToExcelStyle() {
        List<ExportDataWithStyle> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExportDataWithStyle data = new ExportDataWithStyle();
            data.setId(i + 1);
            data.setName("test");
            data.setMonthlyCost("23456");
            data.setYearCost("98734");
            data.setTotalCost("65423");
            dataList.add(data);
        }
        return dataList;
    }

    public List<ExportStyleByAnnotation> fillDataToAnnotation() {
        List<ExportStyleByAnnotation> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExportStyleByAnnotation exportStyleByAnnotation = new ExportStyleByAnnotation();
            exportStyleByAnnotation.setId(i);
            exportStyleByAnnotation.setCost(new BigDecimal("23455.835"));
            exportStyleByAnnotation.setMonthlyCost(new BigDecimal("4345.500"));
            exportStyleByAnnotation.setYearCost(new BigDecimal("45.654"));
            exportStyleByAnnotation.setCreateTime(new Date());
            exportStyleByAnnotation.setUpdateTime(new Date());
            exportStyleByAnnotation.setPerscent("98.876%");
            exportStyleByAnnotation.setPerscent1("56.24%");

        }
        return null;
    }


    public List<DownloadData> fillDataToExcel() throws ParseException {
        List<DownloadData> dataList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = sdf.format(new Date());
        System.out.println(formatDate); // 2021-07-13  String 类型的
        Date parseDate = sdf.parse(formatDate);
        System.out.println(parseDate); // Tue Jul 13 00:00:00 CST 2021 Date类型
        java.sql.Date date = null;
        try {
            date = new java.sql.Date(parseDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(date); // 2021-07-13
        for (int i = 1; i < 11; i++) {
            DownloadData downloadData = new DownloadData();
            downloadData.setId(i);
            downloadData.setName("许波" + i);
            downloadData.setPassword("qwe" + i);
            downloadData.setAddress(new Date());
            downloadData.setCost(new BigDecimal("254"));
            downloadData.setPerRate(new BigDecimal("123"));
            downloadData.setMonthlyCost(new BigDecimal("23564"));
            downloadData.setYearCost(new BigDecimal("49999"));
            downloadData.setTotalCost(new BigDecimal("54139"));
            dataList.add(downloadData);
        }
        return dataList;
    }

    public List<String> getHeadNameList() {
        DownloadData downloadData = new DownloadData();
        List<String> headNameList = new ArrayList<>();
        Class<? extends DownloadData> downloadDataClass = downloadData.getClass();
        for (Field declaredField : downloadDataClass.getDeclaredFields()) {
            // 特殊字符需要转义
            String[] split = declaredField.toString().split("\\.");
            System.out.println(split[split.length - 1]);
            headNameList.add(split[split.length - 1]);
        }
//        headNameList.add("monthlyCost");
        return headNameList;
    }


    /**
     * easypoi
     *
     * @param dto
     * @param response
     */
    @Override
    public void exportExcelAndFormatNumber(JSONObject dto, HttpServletResponse response) {
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("测试数值格式", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//            EasyExcel.write(fileName).head().sheet("测试easypoi").doWrite();
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("导出文件异常");
        }
    }


    /**
     * 页面选择 123  对应枚举中 id 123 456 678
     * @param enumList
     * @return
     */
    @Override
    public List<List<String>> fillHead(List<DownloadDateEnum> enumList) {
//    public List<String> fillHead(List<DownloadDateEnum> enumList) {
        List<List<String>> headList = new ArrayList<>();
        List<String> selectHeadList = new ArrayList<>();
        if(enumList.size() != 0) {
            enumList.stream().forEach(e -> {
                List<String> list =new ArrayList<>();
                list.add(e.getUpName());
                headList.add(list);
            });
        }
//        selectHeadList.stream().forEach(e -> headList.);
        return headList;
    }

    /**
     * List<Object> 里面放的是一列的数据
     * 需要将每一列自定义的数据封装进去 使用的是集合接=接收数据List<List<Onject>>
     * 手动填充有问题 就你不能自定义列了 scenarios
     *
     *
     * @param enumList
     * @return
     */
    @Override
    public List<List<Object>> fillDateToList(List<DownloadDateEnum> enumList) {
        List<String> lowNameList = enumList.stream().map(e -> e.getLowName()).collect(Collectors.toList());
        List<List<Object>> allDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> rowList = new ArrayList<>();
            if(lowNameList.contains("druid")) {
                rowList.add("druid" + i);
            }
            if(lowNameList.contains("druidage")) {
                rowList.add(20 + i);
            }
            if(lowNameList.contains("druidaddress")) {
                rowList.add("sz" + i);
            }

            if(lowNameList.contains("chenzikun")) {
                rowList.add("chenzikun" + i);
            }
            if(lowNameList.contains("chenzikunage")) {
                rowList.add(25 + i);
            }
            if(lowNameList.contains("chenzikunaddress")) {
                rowList.add("sh" + i);
            }

            if(lowNameList.contains("xubo")) {
                rowList.add("xubo" + i);
            }
            if(lowNameList.contains("xuboage")) {
                rowList.add(30 + i);
            }
            if(lowNameList.contains("xuboaddress")) {
                rowList.add("az" + i);
            }
            allDataList.add(rowList);
        }
        return allDataList;
    }


}
