package offer;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/7/16.
 * -------------------------------------------------------------------------------------
 * 返回链表的倒数第k个节点
 * -------------------------------------------------------------------------------------
 * -------------------------------------------------------------------------------------
 * 思路：
 * 用快慢指针，先将fast指针向前移动k位，如果期间，fast指针已经为null，而前一个指针并没有指到最后一个节点，那么返回null，
 * 可以通过计数来实现
 * 然后while(fast!=null)，同时移动快慢指针
 * 最后返回慢指针
 */
public class LinkedLastKNode {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                if (i <= k - 1) {
                    return null;
                }
            }
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.add(new int[]{1, 2, 3, 4, 5});
//        head.print();
        System.out.println(new LinkedLastKNode().FindKthToTail(head.head, 6));
    }
}
