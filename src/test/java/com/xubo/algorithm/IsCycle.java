package com.xubo.algorithm;

import java.util.ArrayList;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 下午 02:05
 * @Description
 * 判断链表是否有环
 * 方案1
 *  将node放入HashSet集合中，然后依次遍历链表，并Contains(key) ，如果return true，就有环
 * 方案2
 *  定义两个指针(对象) p1 p2 ,p1每次向后移动一个位置，p2 每次向后移动两个位置，如果有环，最终p1 p2 就会相遇
 *  此方法类似追及问题
 *
 * 扩展问题 ：
 *  如果链表有环，怎么求环的长度
 *      当p1 与 p2 相遇的时候开始计算，当他们再次相遇的时候，p1走了多长就是环的长度(p1比p2满1)
 *      环长 = 每次速度差 * 前进长度(较慢的那一个)
 *  求环节点
 *
 */
public class IsCycle {

    public static boolean isCycle(Nodes head) {
        Nodes p1 = head;
        Nodes p2 = head;
//        这个地方判断 为什么是 p2.next 而不是 p2.next.next
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next; // p2.next != null 就够了，至于 p2.next 后面是否还有节点就不重要
            if(p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Nodes n1 = new Nodes(8);
        Nodes n2 = new Nodes(9);
        Nodes n3 = new Nodes(4);
        Nodes n4 = new Nodes(2);
        Nodes n5 = new Nodes(7);
        Nodes n6 = new Nodes(81);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        boolean isCycle = isCycle(n1);
        System.out.println(isCycle);
    }
}

class Nodes {
    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
