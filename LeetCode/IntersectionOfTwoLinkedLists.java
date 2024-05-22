package LeetCode;

//URL:https://leetcode.com/problems/intersection-of-two-linked-lists/

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {      //Time Complexity = O(n + m)
        List<ListNode> bucket = new ArrayList<>();                             //Space Complexity = O(n)
        while(headA != null){
            bucket.add(headA);                                                 //Not the best approach
            headA = headA.next;                                               // Optimal approach 👇👇👇
        }
        while(headB != null){
            if(bucket.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    public ListNode getIntersection2(ListNode headA, ListNode headB){     //Messy version of optimal approach
        int diff = getLenDiff(headA, headB);
        if(diff > 0){
            while(diff-- != 0){
                headA = headA.next;
            }
        }
        else if(diff < 0){
            while(diff++ != 0){
                headB = headB.next;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public static int getLenDiff(ListNode A, ListNode B){
        int lenA = 0;
        int lenB = 0;
        while(A != null){
            lenA++;
            A = A.next;
        }
        while(B != null){
            lenB++;
            B = B.next;
        }
        return lenA - lenB;
    }
    public ListNode getIntersection3(ListNode headA, ListNode headB){         //Best version of optimal approach
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while(dummyA != dummyB){
            dummyA = dummyA != null ? dummyA.next : headB;
            dummyB = dummyB != null ? dummyB.next : headA;
        }
        return dummyB;
    }
}
