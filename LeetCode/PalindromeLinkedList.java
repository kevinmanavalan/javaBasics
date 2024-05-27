package LeetCode;


//URL:https://leetcode.com/problems/palindrome-linked-list/

import java.util.Stack;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {                // T = O(N)
        Stack<Integer> stack = new Stack<>();                   // S = O(N)
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.peek())
                return false;
            stack.pop();
            temp = temp.next;
        }
        return true;
    }
    public static boolean bestApproach(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){              // T = O(N/2)
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);                      // T = O(N/2)
        ListNode first = head;
        ListNode second = newHead;
        while(second != null){                                         // T = O(N/2)
            if(first.val != second.val){
                reverseList(newHead);                                  // T = O(N/2)
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);                                         // T = O(N/2)
        return true;
    }
    public static ListNode reverseList(ListNode head){            // T = O(N/2)
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
