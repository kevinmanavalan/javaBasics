package LeetCode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SumOfLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pointer = result;
        int sum = actualNum(l1) + actualNum(l2);
        pointer.val = sum % 10;
        sum /= 10;
        while (sum != 0) {
            ListNode newNode = new ListNode(sum % 10);
            pointer.next = newNode;
            pointer = pointer.next;
            sum /= 10;
        }
        return result;
    }

    public int actualNum(ListNode l) {
        if (l.next == null) {
            return l.val;
        } else {
            return actualNum(l.next) * 10 + l.val;
        }
    }
}

