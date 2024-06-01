package LeetCode;
import java.util.HashMap;
import java.util.Map;

//URL:https://leetcode.com/problems/copy-list-with-random-pointer/

public class CopyListWithRandomPointers {
    public ListNode  copyRandomList(ListNode head) {
        Map<ListNode, ListNode> nodeMap = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            ListNode newNode = new ListNode(temp.val);
            nodeMap.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            ListNode copyNode = nodeMap.get(temp);
            copyNode.next = nodeMap.get(temp.next);
            copyNode.random = nodeMap.get(temp.random);
            temp = temp.next;
        }
        return nodeMap.get(head);
    }
    public ListNode bestApproach(ListNode head){             // T = O(3N)
        ListNode temp = head;
        while(temp != null){
            ListNode copyNode = new ListNode(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tempres = res;
        temp = head;
        while(temp != null){
            tempres.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            tempres = tempres.next;
        }
        return res.next;
    }
}
