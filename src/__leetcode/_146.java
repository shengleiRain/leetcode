package __leetcode;


/**
 * @author Rain
 * @date 2019/6/28.
 */
public class _146 {


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

//        cache.put(1, 1);
//        cache.put(4, 1);
    }

}

class LRUCache {
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(-1, -1); //充当哨兵，无意义
        tail = head;
    }

    public int get(int key) {
        Node node = head;
        while ((node = node.next) != null) {
            if (node.key == key) {
                // 将该节点移到尾部
                if (node != tail) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    tail.next = node;
                    node.prev = tail;
                    node.next = null;
                    tail = node;
                }
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = head;
        Node newNode = null;
        // 从头开始遍历，看key是否在链表中
        while ((node = node.next) != null && key != node.key) ;
        /**
         * key在链表中，那么直接将它移到链表尾部
         */
        if (node != null) {
            if (node == tail) {
                node.value = value;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            node.value=value;
            tail = node;
            return;
        }

        // 缓存空间已经满了，删除头节点.next
        if (size >= capacity) {
            if (head.next != null) {
                Node second = head.next.next;
                head.next = null;
                head.next = second;
                if (second != null) {
                    second.prev = head;

                } else {
                    tail = null;
                    tail = head;
                }
                size--;
            }
        }
        if (size < capacity) {
            newNode = new Node(key, value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }


    }

    class Node {
        int value;
        int key;
        Node prev;//前驱节点
        Node next;//后驱节点

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}


