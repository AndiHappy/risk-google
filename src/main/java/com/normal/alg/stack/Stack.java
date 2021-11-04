package com.normal.alg.stack;

import util.ListNode;

public class Stack {


    /**
     * 链表和
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.util.Stack<Integer> s1 = new java.util.Stack<Integer>();
        java.util.Stack<Integer> s2 = new java.util.Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        // 相当于是后插入
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
