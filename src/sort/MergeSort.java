package sort;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class MergeSort {
    public static void sort(int[] items) {
        mergeSort(items, 0, items.length - 1);
    }

    private static void mergeSort(int[] items, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergeSort(items, start, middle);
        mergeSort(items, middle + 1, end);
        merge(items, start, middle, end);
    }

    private static void merge(int[] items, int start, int middle, int end) {
        int i = start, j = middle + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while (i <= middle && j <= end) {
            if (items[i] > items[j]) {
                temp[index++] = items[j++];
            } else {
                temp[index++] = items[i++];
            }
        }
        while (i <= middle) {
            temp[index++] = items[i++];
        }
        while (j <= end) {
            temp[index++] = items[j++];
        }
        System.arraycopy(temp, 0, items, start, end - start + 1);
    }


}

