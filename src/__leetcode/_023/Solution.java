package __leetcode._023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rain on 2019/5/26.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        ListNode node = result;
        boolean flag = true;
        while (flag) {
            int minVal = 0;
            flag = false;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    minVal = !flag ? lists[i].val : Math.min(minVal, lists[i].val);
                    index = lists[i].val <= minVal ? i : index;
                    flag = true;
                }
            }
            if (lists[index] != null)
                lists[index] = lists[index].next;
            if (flag) {
                if (result == null) {
                    result = new ListNode(minVal);
                    node = result;
                } else {
                    node.next = new ListNode(minVal);
                    node = node.next;
                }
            }

        }
        return result;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        ListNode node = result;
        List<Integer> allNums = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                allNums.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(allNums);

        for (int num : allNums) {
            if (result == null) {
                result = new ListNode(num);
                node = result;
            } else {
                node.next = new ListNode(num);
                node = node.next;
            }
        }
        return result;
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int amount = lists.length, interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += (interval * 2)) {
                lists[i] = merge2List(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return amount > 0 ? lists[0] : null;
    }

    private static ListNode merge2List(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return result.next;
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(-1);

        ListNode node1 = head1;
        ListNode node2 = head2;
        ListNode node3 = head3;
        for (int i = 0; i < 3; i++) {
            node1.next = new ListNode(i);
            node1 = node1.next;
        }

        for (int i = 0; i < 5; i++) {
            node2.next = new ListNode(i + 5);
            node2 = node2.next;
        }

        for (int i = 0; i < 6; i++) {
            node3.next = new ListNode(3 * i);
            node3 = node3.next;
        }

        print(head1);
        print(head2);
        print(merge2List(head1, head2));
//        print(head3);
//
//        ListNode[] listNodes = {head1, head2, head3};
//        print(mergeKLists2(listNodes));

    }
}
