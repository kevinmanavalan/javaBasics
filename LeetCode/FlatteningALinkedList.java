package LeetCode;


//URL:https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

public class FlatteningALinkedList {
    public ListNode flatten(ListNode root){
        if(root != null || root.next == null){
            return root;
        }
        root.next = flatten(root.next);
        root = mergeTwoLists(root, root.next);
        return root;
    }
    public static ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while(a != null && b != null){
            if(a.val <= b.val){
                temp.child = a;
                a = a.child;
            }
            else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }
        if(a != null){
            temp.child = a;
        }
        else {
            temp.child = b;
        }
        return res.child;
    }
}
