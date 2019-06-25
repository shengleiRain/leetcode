package __leetcode.array_linked_list;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/6/24.
 */
public class _024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null && cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next=second.next;
            cur.next=second;
            cur.next.next=first;
            cur=cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode nullNode = new ListNode(-1);
        nullNode.add(values);
        nullNode.print();
        nullNode.head = new _024().swapPairs(nullNode.head);
        nullNode.print();
    }
}
