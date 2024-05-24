package LeetCode;

//URL:https://leetcode.com/problems/reverse-nodes-in-k-group

public class ReverseNodesInKGroup {
    public static ListNode getKthNode(ListNode temp, int k) {
        k--;
        while (temp != null && k-- > 0) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reverseList(ListNode temp) {
        ListNode prevNode = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null)
                    prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if (temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
