package sort;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class QuickSort {


    public static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    private static void sort(int[] items, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        int pivot = items[mid], i = start, j = end;
        while (i < j) {
            while (i < j && items[i] < pivot) {
                i++;
            }
            while (i < j && items[j] > pivot) {
                j--;
            }
            swap(items, i, j);
        }
        sort(items, start, mid - 1);
        sort(items, mid + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
