package com.nyb.demo.algorithm;

/**
 * @Author:nyb
 * @DESC: 链表反转
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Date: Created in 9:46 2020/11/12
 * @Modified By:
 */
public class ReverseList {

    public static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * 实现步骤：
     *
     * 创建一个带头节点的链表resultList
     * 定义一个循环链表变量p，p的初始值为待反转的链表
     * 遍历待反转的链表，遍历条件为 (p !=null)
     * 3.1 定义一个临时链表变量tempList保存p->next的值（因为p->next值会改变），用于下一次循环。
     * 3.2 把p当前指向的首节点和resultList链表的头节点之后的节点拼接起来。
     * 3.3 把3.2步骤中拼接的节点 再拼接到resultList头节点后。
     * 3.4 p重新赋值为3.1步骤中保存的tempList的值。
     * 返回resultList->next.即反转后的链表。
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        ListNode result = new ListNode(-1);
        ListNode p=head;
        while (p!=null){
            ListNode tempList=p.next;
            p.next=result.next;
            result.next=p;
            p=tempList;
        }
        return result.next;
    }
}
