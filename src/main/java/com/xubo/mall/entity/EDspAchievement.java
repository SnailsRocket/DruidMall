package com.xubo.mall.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author Druid
 * @Date 2021/6/28 9:59
 */
@Getter
public enum EDspAchievement {

    /**
     * 用户名和归属id不能写入枚举里面
     * 用户名称
     * 归属BA
     * 年度汇总 y   前三个固定显示
     * m1
     * m2
     * m3
     * q1
     * m4
     * m5
     * m6
     * q2
     * m7
     * m8
     * m9
     * q3
     * m10
     * m11
     * m12
     * q4
     */
    M1_FMDP_BUDGETUSD(1, "1月FMDP预算（$）", "m1FirstMdpBudgetUsd", "money", 1),
    M1_COST(2, "1月花费（$）", "m1Cost", "money", 1),
    M1_ACHIEVEMENTRATE(3, "1月达成率", "m1AchievementRate", "rate", 1),
    M2_FMDP_BUDGETUSD(4, "2月FMDP预算（$）", "m2FirstMdpBudgetUsd", "money", 2),
    M2_COST(5, "2月花费（$）", "m2Cost", "money", 2),
    M2_ACHIEVEMENTRATE(6, "2月达成率", "m2AchievementRate", "rate", 2),
    M3_FMDP_BUDGETUSD(7, "3月FMDP预算（$）", "m3FirstMdpBudgetUsd", "money", 3),
    M3_COST(8, "3月花费（$）", "m3Cost", "money", 3),
    M3_ACHIEVEMENTRATE(9, "3月达成率", "m3AchievementRate", "rate",3),
    Q1_FMDP_BUDGETUSD(10, "Q1FMDP预算（$）", "q1FirstMdpBudgetUsd", "money",4),
    Q1_COST(11, "Q1月花费（$）", "q1Cost", "money",4),
    Q1_ACHIEVEMENTRATE(12, "Q1达成率", "q1AchievementRate", "rate",4),
    M4_FMDP_BUDGETUSD(13, "4月FMDP预算（$）", "m4FirstMdpBudgetUsd", "money",5),
    M4_COST(14, "4月花费（$）", "m4Cost", "money",5),
    M4_ACHIEVEMENTRATE(15, "4月达成率", "m4AchievementRate", "rate",5),
    M5_FMDP_BUDGETUSD(16, "5月FMDP预算（$）", "m5FirstMdpBudgetUsd", "money",6),
    M5_COST(17, "5月花费（$）", "m5Cost", "money",6),
    M5_ACHIEVEMENTRATE(18, "5月达成率", "m5AchievementRate", "rate",6),
    M6_FMDP_BUDGETUSD(19, "6月FMDP预算（$）", "m6FirstMdpBudgetUsd", "money",7),
    M6_COST(20, "6月花费（$）", "m6Cost", "money",7),
    M6_ACHIEVEMENTRATE(21, "6月达成率", "m6AchievementRate", "rate",7),
    Q2_FMDP_BUDGETUSD(22, "Q2FMDP预算（$）", "q2FirstMdpBudgetUsd", "money",8),
    Q2_COST(23, "Q2月花费（$）", "q2Cost", "money",8),
    Q2_ACHIEVEMENTRATE(24, "Q2达成率", "q2AchievementRate", "rate",8),
    M7_FMDP_BUDGETUSD(25, "7月FMDP预算（$）", "m7FirstMdpBudgetUsd", "money",9),
    M7_COST(26, "7月花费（$）", "m7Cost", "money",9),
    M7_ACHIEVEMENTRATE(27, "7月达成率", "m7AchievementRate", "rate",9),
    M8_FMDP_BUDGETUSD(28, "8月FMDP预算（$）", "m8FirstMdpBudgetUsd", "money",10),
    M8_COST(29, "8月花费（$）", "m8Cost", "money",10),
    M8_ACHIEVEMENTRATE(30, "8月达成率", "m8AchievementRate", "rate",10),
    M9_FMDP_BUDGETUSD(31, "9月FMDP预算（$）", "m9FirstMdpBudgetUsd", "money",11),
    M9_COST(32, "9月花费（$）", "m9Cost", "money",11),
    M9_ACHIEVEMENTRATE(33, "9月达成率", "m9AchievementRate", "rate",11),
    Q3_FMDP_BUDGETUSD(34, "Q3FMDP预算（$）", "q3FirstMdpBudgetUsd", "money",12),
    Q3_COST(35, "Q3月花费（$）", "q3Cost", "money",12),
    Q3_ACHIEVEMENTRATE(36, "Q3达成率", "q3AchievementRate", "rate",12),
    M10_FMDP_BUDGETUSD(37, "10月FMDP预算（$）", "m10FirstMdpBudgetUsd", "money",13),
    M10_COST(38, "10月花费（$）", "m10Cost", "money",13),
    M10_ACHIEVEMENTRATE(39, "10月达成率", "m10AchievementRate", "rate",13),
    M11_FMDP_BUDGETUSD(40, "11月FMDP预算（$）", "m11FirstMdpBudgetUsd", "money",14),
    M11_COST(41, "11月花费（$）", "m11Cost", "money",14),
    M11_ACHIEVEMENTRATE(42, "11月达成率", "m11AchievementRate", "rate",14),
    M12_FMDP_BUDGETUSD(43, "12月FMDP预算（$）", "m12FirstMdpBudgetUsd", "money",15),
    M12_COST(44, "12月花费（$）", "m12Cost", "money",15),
    M12_ACHIEVEMENTRATE(45, "12月达成率", "m12AchievementRate", "rate",15),
    Q4_FMDP_BUDGETUSD(46, "Q4FMDP预算（$）", "q4FirstMdpBudgetUsd", "money",16),
    Q4_COST(47, "Q4月花费（$）", "q4Cost", "money",16),
    Q4_ACHIEVEMENTRATE(48, "Q4达成率", "q4AchievementRate", "rate",16),
    YEAR_FMDP_BUDGETUSD(49, "年度汇总FMDP预算（$）", "yFirstMdpBudgetUsd", "money",17),
    YEAR_COST(50, "年度汇总花费（$）", "yCost", "money",17),
    YEAR_ACHIEVEMENTRATE(51, "年度汇总达成率", "yAchievementRate", "rate",17);

    Integer id;
    String name;
    String enName;
    String unitType;
    Integer range;

    EDspAchievement(Integer id, String name, String enName, String unitType, Integer range) {
        this.id = id;
        this.name = name;
        this.enName = enName;
        this.unitType = unitType;
        this.range = range;
    }

    public static List<JSONObject> getList() {
        List<JSONObject> list = new ArrayList<>();
        for (EDspAchievement e : EDspAchievement.values())
            list.add(new JSONObject().fluentPut("id", e.getId()).fluentPut("name", e.getName()).fluentPut("enName", e.getEnName()).fluentPut("unitType", e.getUnitType()));
        return list;
    }

    public static String getUnitTypeById(Integer id) {
        if (id == null) return null;
        for (EDspAchievement e : values()) if (e.getId().equals(id)) return e.getUnitType();
        return null;
    }

    public static Optional<EDspAchievement> getById(Integer id) {
        return Arrays.stream(EDspAchievement.values()).filter(e -> e.getId().equals(id)).findFirst();
    }

    public static Optional<EDspAchievement> getUnitType(String filed) {
        return Arrays.stream(EDspAchievement.values()).filter(e -> e.getUnitType().equals(filed)).findFirst();
    }

    public static List<Integer> getIdByRange(Integer range) {
        if(range == null) return null;
        List<Integer> list = new ArrayList<>();
        for (EDspAchievement e : EDspAchievement.values()) if (e.getRange().equals(range)) {
            list.add(e.getId());
        }
        return list;
    }

}
