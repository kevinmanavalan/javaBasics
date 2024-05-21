package LeetCode;

//URL:https://leetcode.com/problems/middle-of-the-linked-list

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode rabbit = head;
        ListNode turtle = head;
        while(rabbit != null && rabbit.next != null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
}
