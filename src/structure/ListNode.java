package structure;

/**
 * @author Rain
 * @date 2019/6/24.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode head;
    public ListNode last;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.next=newNode;
            last = newNode;
        }
    }

    public void add(int[] values) {
        for (int value : values) {
            add(value);
        }
    }

    public void print() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node=node.next;
        }
        System.out.println();
    }
}
