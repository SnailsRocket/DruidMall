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
 *  easyexcel  导出日期类型(不是格式化成日期类型)
 *     参考 ： https://blog.csdn.net/u012723183/article/details/116186863
 *
 *  easyexcel 的坑
 *      1、导出类的属性大写 就会导致 该字段导出的数据为空
 *      2、日期、金额类 是将之格式化为数字类型的字符串(如果cell中不带金额符号、百分比符号，那么就可以格式化成数字) 使用@ContentStyle可以转换成数字类型
 *      3、使用@ContentStyle(dateFormat) 这个注解的时候，如果单元格的width过小的话会出现#### 要解决这个问题就增加单元格的宽度
 *
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
     *  重写了CellWriteHandler 接口，对样式进行了处理
     * @param dto
     * @param response
     */
    @PostMapping("/download/style")
    public void downloadStyle(@RequestBody JSONObject dto, HttpServletResponse response) {
        getExcelDateService.exportTestExcelAndImplCellWriteHandler(response, dto);
    }

    /**
     * 注解的方式对样式进行处理(easyexcel 与 自定义注解)
     * @param dto
     * @param response
     */
    @PostMapping("/exportproperty")
    public void testAnnotation( @RequestBody JSONObject dto, HttpServletResponse response) {
        getExcelDateService.testExcelWithAnnotation(response,dto);

    }

    @PostMapping("/exportcustomhead")
    public void exportcustomhead(@RequestBody JSONObject dto, HttpServletResponse response) {
        getExcelDateService.exportExcelCustomHead(response,dto);

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
