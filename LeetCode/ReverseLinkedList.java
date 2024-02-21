package LeetCode;

public class ReverseLinkedList {
    //URL:/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode previousHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previousHead;
            previousHead = head;
            head = next;
        }
        return previousHead;
    }

    //APPROACH 2
    public ListNode approach2(ListNode head) {
        return reversedList(head, null);
    }

    public ListNode reversedList(ListNode head, ListNode prevHead) {
        if (head == null) return prevHead;
        ListNode next = head.next;
        head.next = prevHead;
        prevHead = head;
        head = next;
        return reversedList(next, prevHead);
    }
}
