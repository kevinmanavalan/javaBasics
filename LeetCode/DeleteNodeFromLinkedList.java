package LeetCode;

//URL:https://leetcode.com/problems/delete-node-in-a-linked-list

public class DeleteNodeFromLinkedList {
    public void deleteNode(ListNode node) {      //Only node to be deleted is provided
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
