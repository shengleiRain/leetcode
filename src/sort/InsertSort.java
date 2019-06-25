package sort;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/25.
 * 插入排序：分为已排序区间和未排序区间，取未排序区间中的元素，逐个插入到已排序区间（始终有序）中
 */
public class InsertSort {
    public static void sort(int[] items) {
        if (items == null || items.length <= 1) return;
        for (int i = 1; i < items.length; i++) {
            int value = items[i];
            int j=i-1;
            for (;j>=0;--j){
                if (items[j]>value){
                    items[j+1]=items[j];
                }else{
                    break;
                }
            }
            items[j+1]=value;//插入数据
        }
    }

    public static void main(String[] args) {
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
