package com.xubo.Interview.sz.fourkmiles.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.util.Assert;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/6/7 10:35
 * dsp系统密码 test c078d5cc
 * 测试公司  70c6fd99
 * liuyilei@4kmiles.com 13015510639  crm am
 *  测试账号报告021   123456xh dsp
 *
 *  dspcrm dspservice 362
 *
 *  prefix suffix
 *
 */
public class GetPassword {

    public static void main(String[] args) {
        String password = "xubo@4kmiles.com";
        String s1 = ((Math.random() * 9 + 1) * 1000 + "").toString();
        byte[] encode = Base64.getEncoder().encode((password+s1).getBytes());
        String s = new String(encode);
        System.out.println(s);

        // eDE4Mzc5NkAxNjMuY29tMTAwMS44NTgyOTAyNjMxNDY%3D
        String test = "eDE4Mzc5NkAxNjMuY29tMTAwMS44NTgyOTAyNjMxNDY=";
        byte[] encodes = Base64.getEncoder().encode(test.getBytes());
        String ss = new String("ss "+ new String(encodes).toString());
        System.out.println(ss);

        byte[] decode = Base64.getDecoder().decode("MTIzNDU2eGg=");
        System.out.println("decz " +new String(decode).toString());

        String str = "";
        try {
            str = new BASE64Encoder().encode(MessageDigest.getInstance("md5").digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        byte[] bytes = null;
        try {
             bytes = new BASE64Decoder().decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String strs = new String(bytes);
        System.out.println(strs);

    }

    @Test
    public void caculate() {
        System.out.println(true || true); // true
        System.out.println(true || false); // true
        System.out.println(false || false); //false
        System.out.println(true && true);  //true
        System.out.println(true && false); //false
        System.out.println(false && false); //false
        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("druid",25);
        linkedHashMap.put("xubo",26);
        linkedHashMap.put("chenzi",27);
        System.out.println(linkedHashMap.get("druid"));
    }

    // 不能写死，万一没有那条 / 路径就错了
    @Test
    public void split() {
        String httpStr = "http://127.0.0.1:1024/?emailtoken=djaiewjfalkeka";
        String[] split = httpStr.split("/");
        for (String s : split) {
            System.out.println(s);
        }
        StringBuffer sb = new StringBuffer();
        StringBuffer append = sb.append(split[0]).append("//").append(split[2]).append(split[3]);
        System.out.println(append.toString());
        System.out.println(split.length);

    }

    @Test
    public void formatData() {
        String time = "2021-06-21 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, df);
        System.out.println(parse.plusDays(1));
        System.out.println(parse.toString());
        Assert.state(false,"dafas");
        Assert.isTrue(false,"正确");


    }

    @Test
    public void format() {
        String strTime = "2021-06-15T03:40:40.000+0000";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String[] split = strTime.split("\\.");
        String[] ts = split[0].split("T");
        System.out.println(ts[0] + " "+ ts[1]);
//        String format = sdf.format(timestamp);
//        String format1 = sdf.format(strTime);
//        System.out.println(format1);
//        System.out.println(format);

    }

    @Test
    public void sendMail() {

    }


    @Test
    public void testEmail() {
        String reg = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        String email = "123@123.com";
        boolean matches = email.matches(reg);
        System.out.println(matches);
    }

    @Test
    public void testRegex() {
        String password = "测试用见附件户";
//        String regx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,40}$";
        String regx = "^{6,40}$";
        System.out.println(password.length());
        boolean matches = password.matches(regx);
        System.out.println(matches);

    }

    /**
     * 计算数组之间的差值
     */
    @Test
    public void caculateArr() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.UK);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String time = "2021-06-15T03:40:40.000+0000";
        String time2 = "2021.06.11 13:40:31.000";
        Date parse = sdf.parse(time);
        Date parse1 = sdf1.parse(parse.toString());
        String format = sdf2.format(parse1);
        System.out.println(format);

        String[] split = time.split("\\.");
        String[] ts = split[0].split("T");
        System.out.println(ts[0] + " " + ts[1]);
//        String result = sdf.format((Object) time);
//        Date parse = sdf.parse(time);
//        System.out.println(parse);
//        System.out.println(result);
    }

    /**
     * 利用stream过滤
     */
    @Test
    public void doFilter() {
        List<JSONObject> list = new ArrayList<>();
        list.add(new JSONObject().fluentPut("siteId", 14).fluentPut("siteName", "日本").fluentPut("userName", "test2").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName", "Guangzhou Issyzone"));
        list.add(new JSONObject().fluentPut("siteId", 3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "1231231312311").fluentPut("advertiserName", "Issyzone"));
        list.add(new JSONObject().fluentPut("siteId", 4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "3434344343342").fluentPut("advertiserName", "bv"));
        list.add(new JSONObject().fluentPut("siteId", 3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "3434232323232").fluentPut("advertiserName", "yzone"));
        list.add(new JSONObject().fluentPut("siteId", 4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "157asd558asd2").fluentPut("advertiserName", "Guangzhne"));
        list.add(new JSONObject().fluentPut("siteId", 4).fluentPut("siteName", "加拿大").fluentPut("userName", "test2").fluentPut("advertiserId", "ascx461279e82").fluentPut("advertiserName", "Guangzzone"));
        list.add(new JSONObject().fluentPut("siteId", 3).fluentPut("siteName", "美国").fluentPut("userName", "test2").fluentPut("advertiserId", "2323232323fef").fluentPut("advertiserName", "Guazone"));
        list.add(new JSONObject().fluentPut("siteId", 3).fluentPut("siteName", "美国").fluentPut("userName", "test3").fluentPut("advertiserId", "9444562260603").fluentPut("advertiserName", "Guangzhou Issyzone"));
        list.add(new JSONObject().fluentPut("siteId", 14).fluentPut("siteName", "日本").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260621").fluentPut("advertiserName", "Guasyzone"));
        list.add(new JSONObject().fluentPut("siteId", 4).fluentPut("siteName", "加拿大").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260698").fluentPut("advertiserName", "Gsyzone"));
        list.add(new JSONObject().fluentPut("siteId", 4).fluentPut("siteName", "加拿大").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260667").fluentPut("advertiserName", "Guangzhoe"));
        list.add(new JSONObject().fluentPut("siteId", 3).fluentPut("siteName", "美国").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName", "Guanho"));
        list.add(new JSONObject().fluentPut("siteId", 14).fluentPut("siteName", "日本").fluentPut("userName", "test3").fluentPut("advertiserId", "9449962260603").fluentPut("advertiserName", "Gue"));


        List<JSONObject> result = new ArrayList<>();
        Map<Object, Map<String, List<JSONObject>>> resultMap = new HashMap<>();
        resultMap = list.stream().collect(
                Collectors.groupingBy(
                        e -> e.getString("userName"),
                        Collectors.groupingBy(
                                o -> o.getString("siteId"))
                )
        );
        Set<Object> keySet = resultMap.keySet();
        for (Object o : keySet) {
            System.out.println(o.toString());
        }
        System.out.println("=======");
        System.out.println(resultMap.size());


    }




}
