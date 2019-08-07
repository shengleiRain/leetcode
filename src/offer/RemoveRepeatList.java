package offer;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/8/6.
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class RemoveRepeatList {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode guard = new ListNode(-1);
        guard.next = pHead;
        ListNode prev = guard, cur = guard.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.add(new int[]{1, 2, 3, 3, 4, 4, 5});
        head.print();
        ListNode newHead = new RemoveRepeatList().deleteDuplication(head.head);

    }
}
