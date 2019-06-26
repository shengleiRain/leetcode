package sort;

import __leetcode.Utils;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class QuickSort {

    /**
     * 单轴双端扫描交换
     *
     * @param items
     */
    public static void deScanSwapSort(int[] items) {
        deScanSwapSort(items, 0, items.length - 1);
    }

    private static void deScanSwapSort(int[] items, int start, int end) {
        if (start >= end) return;
        int pivot = items[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && items[i] < pivot) {
                i++;
            }
            while (i <= j && items[j] >= pivot) {
                j--;
            }
            if (i < j) {
                Utils.swap(items, i, j);
            }
        }
        // j为中心点
        Utils.swap(items, j, start);
        deScanSwapSort(items, start, j - 1);
        deScanSwapSort(items, j + 1, end);
    }

    /**
     * 一端挖坑，一端填充，单轴排序
     *
     * @param items
     */
    public static void fillSort(int[] items) {
        fillSort(items, 0, items.length - 1);
    }

    private static void fillSort(int[] items, int start, int end) {
        if (start >= end) return;
        int pivot = items[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && items[j] > pivot) {
                j--;
            }
            items[i] = items[j];
            while (i < j && items[i] <= pivot) {
                i++;
            }
            items[j] = items[i];
        }
        //相遇点就是中节点，填上坑
        items[i] = pivot;
        fillSort(items, start, i - 1);
        fillSort(items, i + 1, end);
    }

    /**
     * 单向扫描--单轴快排
     *
     * @param items
     */
    public static void forwardScanSort(int[] items) {
        forwardScanSort(items, 0, items.length - 1);
    }

    private static void forwardScanSort(int[] items, int start, int end) {
        if (start >= end) return;
        int pivot = items[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (items[j] < pivot) {
                i++;
                Utils.swap(items, i, j);
            }
        }
        Utils.swap(items,i,start);
        forwardScanSort(items,start,i-1);
        forwardScanSort(items,i+1,end);
    }

    /**
     * 三分单向扫描--单轴快排
     * @param items
     */
    public static void div3ScanSort(int[] items){
        div3ScanSort(items,0,items.length-1);
    }

    private static void div3ScanSort(int[] items,int start,int end){
        if (start>=end) return;

        int pivot = items[start];
        /**
         * [start,i)是小于pivot的元素
         * [i,k)是等于pivot的元素
         * [k,j]是未进行排序的元素
         * (j,]是大于pivot的元素
         *
         */
        int i=start,k=start+1,j=end;
        while (k<=j){
            if (items[k]==pivot){
                k++;
            }else if (items[k]<pivot){
                Utils.swap(items,i,k);
                i++;
                k++;
            }else{
                Utils.swap(items,k,j);
                j--;
            }
        }
        div3ScanSort(items,start,i-1);
        div3ScanSort(items,j+1,end);
    }

    /**
     * 三分双向扫描--单轴快排
     * @param items
     */
    public static void div3DeScanSort(int[] items){
        div3DeScanSort(items,0,items.length-1);
    }

    private static void div3DeScanSort(int[] items,int start,int end){
        if (start>=end) return;

        int pivot = items[start];
        /**
         * [start,i)是小于pivot的元素
         * [i,k)是等于pivot的元素
         * [k,j]是未进行排序的元素
         * (j,]是大于pivot的元素
         *
         */
        int i=start,k=start+1,j=end;

        while (k<=j){
            if (items[k]==pivot){
                k++;
            }else if (items[k]<pivot){
                Utils.swap(items,i,k);
                i++;
                k++;
            }else {
                while (items[j]>pivot){
                    j--;
                    if (k>j) break;
                }
                // 这个说明后面的全部都大于pivot，排序结束
                if (k>j) break;

                if (items[j]<pivot){
                    Utils.swap(items,j,k);
                    Utils.swap(items,i,k);
                    i++;
                }else{
                    Utils.swap(items,k,j);
                }
                k++;
                j--;

            }
        }
        div3DeScanSort(items,start,i-1);
        div3DeScanSort(items,j+1,end);
    }




}
