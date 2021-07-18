package com.xubo.leetcode;

/**
 * @Author Druid_Xu
 * @Date 2020/12/14 上午 10:30
 * @Description
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        addTwoNumbers1(new ListNode(2 ,new ListNode(3,new ListNode(4))),
                new ListNode(4,new ListNode(2,new ListNode(2))));

    }

    /**
     * 思路：先将链表转换成 十进制数字
     *
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    public static void addTwoNumbers1(ListNode l1, ListNode l2) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        while(l2.next != null) {
            sb1.append(l2.val);
        }
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }

    /**
     * 递归法 ：
     *  思路：
     *   这个种不需要转换成十进制的数，直接单个链表里面的值相加，大于10 就进1  / 判断
     *   然后创建新的链表 并将 l1.val + l2.val 对10 取余 的到的结果存储到链表中，然后依次计算下一个链表
     *    (注意：这里有一点，就是val值相加会有进位问题，所以递归的时候会有 i 递归结束条件就是 l1 == l2 ==null && i == 0)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    ListNode dfs(ListNode l, ListNode r, int i) {
        if (l == null && r == null && i == 0) return null;
        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
        // 第一个创建的链表就是个位数相加之后生成的新链表
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
        return node;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
