package com.xubo.mall.service;

import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.entity.DownloadData;
import com.xubo.mall.entity.DownloadDateEnum;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/6/30 14:49
 *
 */
public interface GetExcelDateService {

    void exportTestExcel(HttpServletResponse response, JSONObject dto, List<Integer> selectMenu);

    void testExcelWithAnnotation(HttpServletResponse response, JSONObject dto);

    void exportTestExcelAndImplCellWriteHandler(HttpServletResponse response, JSONObject dto);

    void exportExcelCustomHead(HttpServletResponse response, JSONObject dto);

    List<List<String>> fillHead(List<DownloadDateEnum> enumList);
//    List<String> fillHead(List<DownloadDateEnum> enumList);

    List<List<Object>> fillDateToList(List<DownloadDateEnum> enumList);

    void exportExcelAndFormatNumber(JSONObject dto, HttpServletResponse response);

}
