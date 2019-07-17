package offer;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/7/16.
 * <p>
 * 合并两个有序链表
 */
public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode guard = new ListNode(-1);
        ListNode cur = guard;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        head1.add(new int[]{1, 5, 6, 11});
        head2.add(new int[]{2, 4, 7, 8, 16, 17});

        new MergeList().Merge(head1.head, head2.head);
        head1.print();

    }
}
