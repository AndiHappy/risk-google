package com.normal.alg.recursive;

import util.ListNode;

public class Recursive {

    public static void main(String[] args) {
        System.out.println("keep happy,boy!");

    }

    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null && carry ==0)  return null;
        int sum = (l1!=null?l1.val:0) + (l2 != null?l2.val:0)+carry;
        carry=sum/10;
        return new ListNode(sum%10,addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null));
    }
}
