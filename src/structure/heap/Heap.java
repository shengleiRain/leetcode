package structure.heap;

import java.util.EmptyStackException;

/**
 * @author Rain
 * @date 2019/7/10.
 * 大顶堆
 */
public class Heap {
    // 堆的容量
    private int capacity;
    // 堆中现有的大小
    private int size;
    // 存储value的数组 1-based
    private int[] items;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.items = new int[this.capacity + 1];
        this.size = 0;
    }

    public void buildHeap(int[] items) {
        System.arraycopy(items, 0, this.items, 0, items.length);
        this.size = items.length;
        for (int i = this.size / 2; i > 0; i--) {
            heapify(this.items, i, this.size);
        }
    }


    public void add(int value) {
        // 堆已经满了，不允许再添加
        if (size >= capacity) {
            return;
        }
        // 先将value存进数组中
        items[++size] = value;
        //从下往上进行堆化，也就只要判断刚存进来的value
        int i = size;
        while (i / 2 > 0 && items[i] > items[i / 2]) {
            swap(items, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 删除堆顶的元素
     */
    public int removeMax() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        int max = items[1];
        items[1] = items[size--];

        heapify(items, 1, size);

        return max;

    }

    /**
     * 从上往下堆化
     */
    private void heapify(int[] items, int index, int size) {
        while (true) {
            int maxPos = index;
            if (index * 2 <= size && items[index] < items[index * 2]) {
                maxPos = index * 2;
            }
            if (index * 2 + 1 <= size && items[maxPos] < items[index * 2 + 1]) {
                maxPos = index * 2 + 1;
            }
            if (maxPos == index) break;
            swap(items, maxPos, index);
            index = maxPos;
        }
    }

    private void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


}
