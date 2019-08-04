package offer;

import structure.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 找到两个链表的第一个公共节点
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = findListLength(pHead1);
        int count2 = findListLength(pHead2);
        ListNode p1 = pHead1, p2 = pHead2, res = null;
        if (count1 > count2) {
            int diff = count1 - count2;
            while ((diff--) > 0) {
                p1 = p1.next;
            }
        } else {
            int diff = count2 - count1;
            while ((diff--) > 0) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                res = p1;
                break;
            }
        }

        int[] nums = new int[]{};
        for (int num : nums) {

        }
        return res;

    }

    private int findListLength(ListNode pHead) {
        ListNode p = pHead;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        HashSet<String> set = new HashSet<>();
        String[] arr = set.toArray(new String[0]);
        HashSet<Integer> set1 = new HashSet<>();
        Integer[] arr2 = set1.toArray(new Integer[0]);
        int[] arr3 = Arrays.stream(arr2).mapToInt(Integer::valueOf).toArray();
        int[] arr4 = set1.stream().mapToInt(Integer::valueOf).toArray();
        return count;
    }

    public void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        head1.add(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode head2 = new ListNode(-2);
        head2.add(new int[]{10, 9, 8, 6, 7});
        new FindFirstCommonNode().FindFirstCommonNode(head1.head, head2.head);

    }
}
