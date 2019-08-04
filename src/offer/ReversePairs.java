package offer;

import sort.BubbleSort;

import java.util.Arrays;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class ReversePairs {

    // 用归并排序，在merge过程中求逆序度
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return helper(array, 0, array.length - 1);
    }

    private int helper(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;

        int leftCount = helper(array, start, mid);
        int rightCount = helper(array, mid + 1, end);

        int mergeCount = 0;
        int i = start, j = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
                // 如果i位置的数要大于j位置的话，那么i～mid的数都是大于j位置的，所以要加上mid-i+1
                mergeCount += mid - i + 1;
                mergeCount %= 1000000007;

            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= end) {
            temp[index++] = array[j++];
        }
        System.arraycopy(temp, 0, array, start, end - start + 1);
        return (leftCount + rightCount + mergeCount) % 1000000007;
    }

    // 用快排的思想，求无序数组中的第K个元素
    private int KthNum(int[] array, int k) {
        return KthNum(array, k, 0, array.length - 1);
    }

    private int KthNum(int[] array, int k, int start, int end) {
        if (start == end) {
            return array[k];
        }
        int mid = (start + end) / 2;
        int pivot = array[mid];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left++, right--);
            }
        }
        if (k <= right) {
            return KthNum(array, k, start, right);
        }
        if (k >= left) {
            return KthNum(array, k, left, end);
        }
        return array[k];

    }


    // 归并排序
    private void MergeSort(int[] array) {
        MergeSort(array, 0, array.length - 1);
    }

    private void MergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start, j = middle + 1;
        while (i <= middle && j <= end) {
            if (array[i] > array[j]) {
                temp[index++] = array[j++];
            } else {
                temp[index++] = array[i++];
            }
        }
        while (i <= middle) {
            temp[index++] = array[i++];
        }
        while (j <= end) {
            temp[index++] = array[j++];
        }
        System.arraycopy(temp, 0, array, start, end - start + 1);
    }

    // 快排
    private void QuickSort(int[] array) {
        QuickSort(array, 0, array.length - 1);
    }

    private void QuickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && array[j] >= pivot) {
                j--;
            }
            while (i <= j && array[i] < pivot) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        if (start < j) {
            swap(array, start, j);
        }
        QuickSort(array, start, j - 1);
        QuickSort(array, j + 1, end);
    }

    // 选择排序
    private void SelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    // 插入排序
    private void InsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }


    // 冒泡排序
    private void BubbleSort(int[] array) {
        int len = array.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 6, 1, 7, 9};
        System.out.println(new ReversePairs().KthNum(array, 0));
    }


}
