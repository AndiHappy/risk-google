package LLittle;


import util.ListNode;

public class L21 {
    /**
     * 21. Merge Two Sorted Lists
     * 
     * Merge two sorted linked lists and return it as a new sorted list. The new
     * list should be made by splicing together the nodes of the first two lists.
     * 
     * Example:
     * 
     * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
     */
  

    public static void main(String[] args) {
        System.out.println("Hello world , L21");
       
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(5);

        ListNode head1 = new ListNode(1);
        // head1.next = new ListNode(3);
        // head1.next.next = new ListNode(4);

        System.out.println(L21.mergeTwoLists(head, head1));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curreNode = head;
        while(l1 != null || l2 != null){
            Integer l1value = l1 !=null?l1.val: null;
            Integer l2value = l2 != null ? l2.val : null;
            if(l1value != null && l2value != null){
                if(l1value > l2value){
                    curreNode.next = l2;
                    l2 = l2.next;
                } else{
                    curreNode.next = l1;
                    l1 = l1.next;
                }
                curreNode = curreNode.next;
            }else if(l1value == null && l2value != null){
                curreNode.next = l2;
                break;
            } else if (l1value != null && l2value == null) {
                curreNode.next = l1;
                break;
            }
        }
        return head.next;

    }
}

