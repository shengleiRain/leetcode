package __leetcode.array_linked_list;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/6/24.
 */
public class _025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy,prev=dummy;
        while (true){
            int count=k;
            while (count>0&&tail!=null){
                tail=tail.next;// 找到reverse的最后一个节点
                count--;
            }
            if (tail==null) break;//剩余的未翻转的节点已经不足k
            head=prev.next;// 记录下下一次循环的头节点（哨兵）

            while (prev.next!=tail){
                ListNode temp = prev.next;
                //把temp节点从链表中移除
                prev.next=temp.next;

                // 将temp节点插入到tail后面
                temp.next=tail.next;
                tail.next=temp;
            }
            tail=head;
            prev=head;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        ListNode nullNode = new ListNode(-1);
        nullNode.add(values);
        nullNode.print();
        nullNode.head = new _025().reverseKGroup(nullNode.head, 3);
        nullNode.print();
    }
}
