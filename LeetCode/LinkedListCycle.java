package LeetCode;

//URL:https://leetcode.com/problems/linked-list-cycle

import java.util.List;
import java.util.ArrayList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {           //My stupid solution    T = O(N)
        List<ListNode> links = new ArrayList<>();                     //       S = O(N)
        while(!links.contains(head) && head != null){
            links.add(head);
            head = head.next;
        }
        return head == null ? false : true;
    }
    public boolean bestApproach(ListNode head) {               //T = O(2N)
        ListNode turtle = head;                                //S = O(1)
        ListNode rabbit = head;
        while(rabbit != null && rabbit.next != null){
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(rabbit == turtle){
                return true;
            }
        }
        return false;
    }
}
