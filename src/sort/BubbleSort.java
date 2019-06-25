package sort;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/25.
 * 冒泡排序:前后两两相比，每一次将当前最大的移动到最后面
 */
public class BubbleSort {

    public static void sort(int[] items) {
        if (items == null || items.length <= 1) return;

        for (int i = 0; i < items.length; i++) {
            boolean flag = false;//是否进行了交换操作
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j+1]<items[j]){
                    int temp = items[j+1];
                    items[j+1]=items[j];
                    items[j]=temp;
                    flag=true;
                }
            }
            if (!flag) break;
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
