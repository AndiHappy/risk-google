package com.normal.alg.linkedlist;

import util.ListNode;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 链表的基础性操作
 */
public class LinkedListUtil {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        System.out.println(node);
        // very interesting
        System.out.println(length(node));
        System.out.println(node);
        System.out.println(reversal(node));

    }

    /**
     * 链表的长度
     * */
    public static int length(ListNode node) {
        int len=0;
        while(node != null ){
            node=node.next;
            len++;
        }
        return len;
    }

    /**
     * 链表的翻转
     * */
    public static ListNode reversal(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode head = null;
        ListNode cur = node;
        ListNode next = node.next;
        while (next != null){
            cur.next=head;
            head=cur;
            cur=next;
            next=next.next;
            cur.next=head;
        }
        return cur;
    }


}
