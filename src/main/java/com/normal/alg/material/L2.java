package com.normal.alg.material;

import util.ListNode;

public class L2 {
    public static void main(String[] args) {
        ListNode tmp1=new ListNode(2);
        tmp1.next=new ListNode(4);
        tmp1.next.next=new ListNode(3);

        ListNode tmp2=new ListNode(5);
        tmp2.next=new ListNode(6);
        tmp2.next.next=new ListNode(4);

        ListNode tmp3= addTwoNumbers(tmp1,tmp2);
        System.out.println(tmp3);

        tmp1=new ListNode(9);
        tmp1.next=new ListNode(9);
        tmp1.next.next=new ListNode(9);

        tmp2=new ListNode(9);
        tmp2.next=new ListNode(9);
        tmp2.next.next=new ListNode(9);
        tmp2.next.next.next=new ListNode(9);

        tmp3= addTwoNumbers(tmp1,tmp2);
        System.out.println(tmp3);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = (l1 != null? l1.val:0 ) + (l2 != null?l2.val:0)+carry;
            carry=sum/10;
            pre.next = new ListNode(sum%10);
            pre=pre.next;
            l1=  l1!=null? l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        if(carry>0) pre.next=new ListNode(carry);
        return head.next;
    }
}
