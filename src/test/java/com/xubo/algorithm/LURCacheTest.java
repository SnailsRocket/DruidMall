package com.xubo.algorithm;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 上午 11:39
 * @Description
 * LUR 实现
 */
public class LURCacheTest {

    public static void main(String[] args) {
        LURCache lurCache = new LURCache(5);
        lurCache.put("01","用户1");
        lurCache.put("02","用户2");
        lurCache.put("03","用户3");
        lurCache.put("04","用户4");
        lurCache.put("05","用户5");
        lurCache.get("02");
        lurCache.put("04","用户4信息更改");
        lurCache.put("06","用户6");
        System.out.println(lurCache.get("02"));
        System.out.println(lurCache.get("06"));
        System.out.println(lurCache.get("01")); // null

    }

}
