package util;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int i) {
        this.val=i;
    }
    public ListNode(int i,ListNode next) {
        this.val=i;
        this.next=next;
    }
    public ListNode() {}

    @Override
    public String toString() {
        return "ListNode{val="+ val+" ,next=" + next+"}" ;
    }
}
