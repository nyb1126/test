package com.nyb.demo.algorithm;

/**
 * @Author:nyb
 * @DESC: java实现输入两个单调递增的链表，输出两个链表合成后的链表，
 *          当然我们需要合成后的链表满足单调不减规则
 * @Date: Created in 14:04 2020/11/10
 * @Modified By:
 */
public class MergeTwoList {

    /**
     * 自定义链表
     */
    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * 合并，单调不递减
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode mergeList=null;
        //如果list1的头节点小于list2的头节点，则使用list1的头节点就是新表的头节点
        if (list1.val<list2.val){
            mergeList=list1;
            mergeList.next=merge(list1.next,list2);
        }else {
            mergeList=list2;
            mergeList.next=merge(list1,list2.next);
        }
        return mergeList;
    }

    /**
     * 打印
     * @param listNode
     */
    static void printList(ListNode listNode){
        while (null!=listNode){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next=new ListNode(4);
        list1.next.next=new ListNode(6);
        ListNode list2 = new ListNode(3);
        list2.next=new ListNode(5);
        list2.next.next=new ListNode(7);
        ListNode merge = merge(list1, list2);
        printList(merge);
    }
}
