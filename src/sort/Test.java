package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Test {
    public static void main(String[] args) {
//        int[] items = {3, 2, 3, 1, 6, 8, 10, 34};
        int size = 1000000;
        int[] items = new int[size];
        Random random = new Random(2);
        for (int i = size; i > 0; i--) {
            items[size - i] =random.nextInt(1000);
        }
//        System.out.println(Arrays.toString(items));
//        int[] items= {4,2,6,1,3,5,7};
//        int[] nums = new int[]{5, 4, 3, 2, 1};
        long start = System.currentTimeMillis();
        QuickSort.forwardScanSort(items);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(items));
    }
}
