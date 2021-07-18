package com.xubo.algorithm;

import java.util.HashMap;


/**
 * @Author Druid_Xu
 * @Date 2020/11/5 上午 10:49
 * @Description
 * LRU 算法 实现
 * 下面这段代码不是线程安全的
 * redis 底层也实现了类似 LRU算法
 */
public class LURCache {

    private Node head;
    private Node end;
    private int limit;

    private HashMap<String, Node> hashMap;

    public LURCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if(node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key,String value) {
        Node node = hashMap.get(key);
        if(node == null) {
//            如果不存在就添加，如果这个用户之前不再内存redis里面，就添加进内存(redis)
            if(hashMap.size() >= limit) {
//                内存容量满了就移除，就是用LRU 算法，移除，最近最少使用的数据
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key,node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     *  刷新节点,刷新被访问的节点，移到最右边
     * @param node
     */
    private void refreshNode(Node node) {
        if(node == end) {
//            访问的是尾结点，不需要移动节点
            return;
        }
//        不管此时链表满不满，都需要先删除再添加
        removeNode(node);
        addNode(node);
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    private String removeNode(Node node) {
        if(node == head && node == end) {
            // 移除唯一的节点
            head = null;
            end = null;
        } else if(node == end) {
//            移除尾结点
            end = end.pre;
            end.next = null;
        } else if(node == head) {
//            移除头结点
            head = head.next;
            head.pre = null;
        } else {
//            移除中间节点
            node.pre.next = node.next;
            node.next.pre =  node.pre;
        }
        return node.key;
    }

    /**
     * 添加节点，一般加载链表的右侧，左侧是最近最久未使用的
     * @param node
     */
    private void addNode(Node node) {
//        判断当前是否满了
        if(end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if(head == null) {
            head = node;
        }
    }
}

class Node {
    public Node pre; // 指向前一个节点 (存储节点的地址值)
    public Node next; // 指向后一个节点
    public String key;
    public String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
