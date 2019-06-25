package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rain
 * @date 2019/6/25.
 * 选择排序：分为已排序区间和未排序区间，每次从扫描下未排序区间，
 * 记录下其最小元素的index,然后放到已排序区间的末尾
 */
public class SelectedSort {
    public static void sort(int[] items) {
        if (items == null || items.length <= 1) return;
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[minIndex]) {
                    minIndex = j;
                }
            }
            //交换i和minIndex的元素
            if (i != minIndex) {
                int temp = items[i];
                items[i] = items[minIndex];
                items[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[] items = {3, 2, 3, 1, 6, 8, 10, 34};
        int size = 100000;
        int[] items = new int[size];
        for (int i = size; i > 0; i--) {
            items[size-i]=i;
        }
        long start = System.currentTimeMillis();
        sort(items);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(items));
    }
}
