package com.nyb.demo.algorithm;

/**
 * @Author:nyb
 * @DESC: 判断给定的链表中是否有环
 * @Date: Created in 17:00 2020/11/12
 * @Modified By:
 */
public class HasCycle {

    public static boolean solution(ListNode listNode){
        if (listNode==null){
            return false;
        }
        ListNode fast=listNode;
        ListNode slow=listNode;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            next=null;
        }
    }
}
