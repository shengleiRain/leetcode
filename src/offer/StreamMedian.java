package offer;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

/**
 * @author Rain
 * @date 2019/8/7.
 * <p>
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class StreamMedian {

    // 用来存后一半的数据,小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 用来存前一半的数据，大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // 流中的数据数量
    private int count = 0;

    public void Insert(Integer num) {
        count++;
        if (count == 1) {
            minHeap.add(num);
        } else {
            if (count % 2 == 0) {
                if (minHeap.peek() < num) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                if (maxHeap.peek() > num) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }

    }

    public Double GetMedian() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        if (count % 2 == 0) {
            int num1 = minHeap.peek();
            int num2 = maxHeap.peek();
            return ((double) num1 + num2) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] streams = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        StreamMedian me = new StreamMedian();
        for (int num : streams) {
            me.Insert(num);
            System.out.println(me.GetMedian());

        }
    }
}
