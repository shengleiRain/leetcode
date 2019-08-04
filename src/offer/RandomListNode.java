package offer;

import java.util.HashMap;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = null, newP = newHead, p = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        p = pHead;
        while (p != null) {
            if (p == pHead) {
                newHead = map.get(p);
                newP = newHead;
            } else {
                newP.next = map.getOrDefault(p, null);
                newP = newP.next;
            }
            newP.random = map.getOrDefault(p.random, null);
            p = p.next;
        }

        return newHead;
    }

    /**
     * 1,将节点A复制一份A1，然后将A1插入到A的后面
     * 2，将节点A1的random赋值为A.random.next
     * 3,拆分，将复制后的节点弄下来
     *
     * @param pHead
     * @return
     */
    public static RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode p = pHead;
        // 1,将节点A复制一份A1，然后将A1插入到A的后面
        while (p != null) {
            RandomListNode pCopy = new RandomListNode(p.label);
            RandomListNode temp = p.next;
            p.next = pCopy;
            pCopy.next = temp;
            p = temp;
        }
        // 2，将节点A1的random赋值为A.random.next
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 拆分，将复制后的节点弄下来
        RandomListNode copyHead = pHead.next;
        p = pHead;

        while (p != null) {
            RandomListNode cloneNode = p.next;
            p.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            p = p.next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node3.random = null;
        node4.random = node2;
        node5.random = null;

        RandomListNode result = RandomListNode.Clone(node1);
    }
}
