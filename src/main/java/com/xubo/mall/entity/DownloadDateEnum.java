package com.xubo.mall.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author Administrator
 * @Date 2021/6/30 18:39
 */
@Getter
public enum DownloadDateEnum {

    DRUID(1, "druid", "Druid","String", 1),
    DRUIDAGE(2, "druidage", "DruidAge", "Integer", 1),
    DRUIDADDRESS(3, "druidaddress", "DruidAddress", "String", 1),
    XUBO(4, "xubo", "Xubo", "String", 2),
    XUBOAGE(5, "xuboage", "XuboAge", "Integer", 2),
    XUBOADDRESS(6, "xuboaddress", "XuboAddress", "String", 2),
    CHENZIKUN(7, "chenzikun", "ChenZiKun", "String", 3),
    CHENZIKUNAGE(8, "chenzikunage", "ChenZiKunAge", "Integer", 3),
    CHENZIKUNADDRESS(9, "chenzikunaddress", "ChenZiKunAddress", "String", 3);

    Integer id;
    String lowName;
    String upName;
    String type;
    Integer range;

    DownloadDateEnum() {
    }

    DownloadDateEnum(Integer id, String lowName, String upName, String type, Integer range) {
        this.id = id;
        this.lowName = lowName;
        this.upName = upName;
        this.type = type;
        this.range = range;
    }

    public static List<JSONObject> getList() {
        List<JSONObject> list = new ArrayList<>();
        for (DownloadDateEnum e : DownloadDateEnum.values()) {
            list.add(new JSONObject().fluentPut("id", e.getId()).fluentPut("lowName", e.getLowName()).fluentPut("upName", e.getUpName())
                .fluentPut("type", e.getType()).fluentPut("range", e.getRange()));
        }
        return list;
    }

    public static String getTypeById(Integer id) {
        if(id == null) return null;
        for (DownloadDateEnum e : DownloadDateEnum.values()) if(e.getId().equals(id)) return e.getType();
        return null;
    }

    public static Optional<DownloadDateEnum> getById(Integer id) {
        return Arrays.stream(DownloadDateEnum.values()).filter(e -> e.getId().equals(id)).findFirst();
    }

    public static Optional<DownloadDateEnum> getType(String type) {
        return Arrays.stream(DownloadDateEnum.values()).filter(e -> e.getType().equals(type)).findFirst();
    }

    public static List<Integer> getIdByRange(Integer range) {
        if(range == null) return null;
        List<Integer> list = new ArrayList<>();
        for (DownloadDateEnum e : DownloadDateEnum.values()) {
            if(e.getRange().equals(range)) {
                list.add(e.getId());
            }
        }
        return list;
    }

    public static List<String> getUpNameByRange(Integer range) {
        if(range == null) return null;
        List<String> list = new ArrayList<>();
        for (DownloadDateEnum e : DownloadDateEnum.values()) {
            if(e.getRange().equals(range)) {
                list.add(e.getUpName());
            }
        }
        return list;
    }

    public static List<DownloadDateEnum> getDownloadDateEnumByRange(Integer range) {
        if(range == null) return null;
        List<DownloadDateEnum> list = new ArrayList<>();
        for (DownloadDateEnum e : DownloadDateEnum.values()) {
            if(e.getRange().equals(range)) {
                list.add(e);
            }
        }
        return list;
    }

}
