package __leetcode.array_linked_list;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/6/24.
 */
public class _092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        while (m>1){
            m--;
            n--;
            prev=cur;
            cur=cur.next;
        }
        // 记录下翻转后的尾节点和头节点的父节点
        ListNode tail=cur,headParent=prev;
        ListNode temp=null;
        while (n>0){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
            n--;
        }
        //考虑头节点是否有父节点
        if (headParent!=null){
            // 整个链表的头节点仍然是之前的head
            headParent.next=prev;
        }else{
            head=prev;
        }
        tail.next=cur;
        return head;

    }


    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        ListNode nullNode = new ListNode(-1);
        nullNode.add(values);
        nullNode.print();
        nullNode.head = new _092().reverseBetween(nullNode.head, 2, 5);
        nullNode.print();
    }

}
