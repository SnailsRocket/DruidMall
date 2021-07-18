package com.xubo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Druid_Xu
 * @Date 2020/10/14 下午 02:18
 * @Description HashMap
 * hashmap 的底层数据结构是 数组 + 链表/红黑树
 *
 */
public class HashMapTest {
    private Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        System.out.println(osName);
        System.out.println(userName);

    }

    /**
     * map 是以键值对存储元素的
     * key 必须要唯一，value 可以重复，key重复会覆盖之前的元素
     *
     */
    private void putElement() {
        map.put("Druid","xubo");
        map.put("chenzikun","Bruse");
        map.put("liyaoting","dashanghai");
    }

    private void delElement() {
        map.remove("Druid");
        map.remove("Druid","xubo");
    }

    private void iterator() {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "  " + map.get(key));
        }
    }

    private void updateElement() {
        map.replace("Druid","xu");
        map.replace("Druid","xu","xubo");
    }

    private void containsKey() {
        if(map.containsKey("Druid")) {
            System.out.println("key contains ： Druid");
        }
    }




}
