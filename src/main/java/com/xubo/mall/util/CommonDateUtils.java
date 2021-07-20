package com.xubo.mall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xubo
 * @Date 2021/7/8 15:34
 */
public class CommonDateUtils {

    public static Date parseDate(String cellValue, String[] patterns) {

        SimpleDateFormat sdf = new SimpleDateFormat(patterns[1]);
        Date parseDate = null;
        try {
            parseDate = sdf.parse(cellValue);
        } catch (ParseException e) {
            // 这个异常不能往上抛，抛给RowWriteHandler之后也要去处理
            e.printStackTrace();
        }

        return parseDate;
    }

}
