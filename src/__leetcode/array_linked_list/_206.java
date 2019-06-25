package __leetcode.array_linked_list;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/6/24.
 */
public class _206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }



    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        ListNode nullNode = new ListNode(-1);
        nullNode.add(values);
        nullNode.print();
        nullNode.head= new _206().reverseList(nullNode.head);
        nullNode.print();
    }
}
