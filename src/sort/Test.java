package sort;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Test {
    public static void main(String[] args) {
//        int[] items = {3, 2, 3, 1, 6, 8, 10, 34};
        int size = 10;
        int[] items = new int[size];
        for (int i = size; i > 0; i--) {
            items[size - i] = i;
        }
//        int[] nums = new int[]{5, 4, 3, 2, 1};
        long start = System.currentTimeMillis();
        QuickSort.sort(items);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(items));

//        long start = System.currentTimeMillis();
//        MergeSort.sort(items);
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(Arrays.toString(items));
    }
}
