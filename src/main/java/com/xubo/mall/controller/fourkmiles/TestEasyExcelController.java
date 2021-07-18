package com.xubo.mall.controller.fourkmiles;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.xubo.mall.entity.DownloadData;
import com.xubo.mall.service.GetExcelDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xubo
 * @Date 2021/6/28 15:52
 *
 *  文件乱码问题：
 *      1.需要使用URLEncoder类对文件名进行编码处理
 *      2.在response的请求头中设置Content-disposition:attachment;filename*=utf-8''
 *  easyexcel 参考 https://blog.csdn.net/qq_31964019/article/details/103730631
 *  加班 ： 10， 16 ， 17 ，18， 19,21,22,23，24
 *  Controller 里面只做数据校验，不写业务逻辑(校验可以通过一些注解来实现)
 */
@RestController
@RequestMapping("/test")
public class TestEasyExcelController {

    @Autowired
    private GetExcelDateService getExcelDateService;

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>1. 创建excel对应的实体对象 参照{@link DownloadData}
     * <p>2. 设置返回的 参数
     * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     * 这个导出的demo可以跑了
     */
    @PostMapping("/download")
    public void download(@RequestBody JSONObject dto, HttpServletResponse response) throws IOException {
        List<Integer> selectMenu = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        // 将导出功能抽出到service中
        getExcelDateService.exportTestExcel(response, dto, selectMenu);
    }


    @PostMapping("/downloads")
    public void downloadAndSetStyle(@RequestBody JSONObject dto, HttpServletResponse response) {

        getExcelDateService.exportExcelAndFormatNumber(dto, response);

    }


    /**
     * 暂时用不上
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>3. 直接读即可
     */
    /*@PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
        return "success";
    }*/


}
