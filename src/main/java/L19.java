import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ListNode;

public class L19 {
    /**
     * 19. Remove Nth Node From End of List
     * 
     * Given a linked list, remove the n-th node from the end of list and return its
     * head.
     * 
     * Example:
     * 
     * Given linked list: 1->2->3->4->5, and n = 2.
     * 
     * After removing the second node from the end, the linked list becomes
     * 1->2->3->5. Note:
     * 
     * Given n will always be valid.
     * 
     * Follow up:
     * 
     * Could you do this in one pass?
     */
  

    public static void main(String[] args) {
        System.out.println("Hello world!");
       ListNode head = new ListNode(1);
       head.next=new ListNode(2);
       head.next.next = new ListNode(3);
       head.next.next.next=new ListNode(4);
       head.next.next.next.next= new ListNode(5);
    //    System.out.println(L19.removeNthFromEnd(head, 1).toString());
    //    System.out.println(L19.removeNthFromEnd(head, 2).toString());
    //    System.out.println(L19.removeNthFromEnd(head, 3).toString());
    //    System.out.println(L19.removeNthFromEnd(head, 4).toString());
       System.out.println(L19.removeNthFromEnd(head, 5).toString());

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <=0) return head;
        // end point
        ListNode secondListNode = head;
        //dele point pre node！
        ListNode firstListNode = head;

        while(n>0 && secondListNode != null){
           secondListNode = secondListNode.next;
           n--;
        }

        if(secondListNode == null && n == 0){
            return head.next;
        }

        while (secondListNode.next != null) {
            firstListNode = firstListNode.next;
            secondListNode = secondListNode.next;
        }
        firstListNode.next = firstListNode.next.next;
        return head;
    }
}

