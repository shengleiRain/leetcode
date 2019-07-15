package offer;

import structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Rain
 * @date 2019/7/15.
 * 从尾到头打印链表
 * <p>
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class ReverseLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode node = listNode;
        ArrayList<Integer> res = new ArrayList<>();
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        Collections.reverse(res);
        return res;
    }


}
