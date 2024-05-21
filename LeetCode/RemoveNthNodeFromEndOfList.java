package LeetCode;

//URL:https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode turtle = head;
        ListNode rabbit = head;
        for(int i = 0; i < n; i++){
            rabbit = rabbit.next;
        }
        if(rabbit == null){
            ListNode newHead = head.next;
            head = null;
            return newHead;
        }
        while(rabbit.next != null){
            turtle = turtle.next;
            rabbit = rabbit.next;
        }
        ListNode delNode = turtle.next;
        turtle.next = turtle.next.next;
        delNode = null;
        return head;
    }
}
