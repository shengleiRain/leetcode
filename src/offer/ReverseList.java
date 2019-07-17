package offer;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/7/16.
 * -------------------------------------------------------------------------------------
 * 反转链表
 * -------------------------------------------------------------------------------------
 * <p>
 * -------------------------------------------------------------------------------------
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, cur = head;
        ListNode temp;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        return cur;
    }
}
