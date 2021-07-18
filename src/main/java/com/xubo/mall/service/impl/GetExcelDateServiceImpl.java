package com.xubo.mall.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.xubo.mall.entity.DownloadData;
import com.xubo.mall.entity.DownloadDateEnum;
import com.xubo.mall.service.GetExcelDateService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date 2021/6/30 14:49
 * Easyexcel 使用自定义导出excel,无法使使用自定义的人列，(所以无法格式化)
 * 自定义实体类和货币格式化只能选一个
 */
@Service
public class GetExcelDateServiceImpl implements GetExcelDateService {

    /**
     * easyexcel
     *
     * @param response
     * @param dto
     * @param selectMenu
     */
    @Override
    public void exportTestExcel(HttpServletResponse response, JSONObject dto, List<Integer> selectMenu) {
        List<DownloadDateEnum> downloadDateEnums = new ArrayList<>();
        selectMenu.stream().forEach(e -> downloadDateEnums.addAll(DownloadDateEnum.getDownloadDateEnumByRange(Integer.valueOf(e))));
        try (ServletOutputStream outputStream = response.getOutputStream()) {

//            response.setContentType("application/vnd.ms-excel"); //application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
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
            EasyExcel.write(response.getOutputStream(),DownloadData.class).sheet("测试excel").doWrite(dataList);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("导出文件异常");
        }
    }

    public List<DownloadData> fillDataToExcel() {
        List<DownloadData> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DownloadData downloadData = new DownloadData();
            downloadData.setId(i);
            downloadData.setName("许波" + i);
            downloadData.setPassword("qwe" + i);
            downloadData.setAddress("苏州" + i);
            dataList.add(downloadData);
        }
        return dataList;
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
