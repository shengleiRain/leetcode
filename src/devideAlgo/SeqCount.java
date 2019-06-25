package devideAlgo;

/**
 * Created by Rain on 2019/6/5.
 * <p>
 * 采用分治算法来计算一个数组中的逆序度
 */
public class SeqCount {
    // 全局变量，记录逆序度
    private static int num = 0;

    public static int count(int[] nums) {
        mergeCount(nums, 0, nums.length - 1);
        return num;
    }

    /**
     * 采用左闭右闭
     */
    private static void mergeCount(int[] nums, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergeCount(nums, start, middle);
        mergeCount(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }


    private static void merge(int[] nums, int start, int middle, int end) {
        int i = start, j = middle + 1, k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= middle && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                num += (middle - i + 1);//统计start到middle之间  比nums[j]大的元素
                temp[k++] = nums[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end - start + 1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 1};
        count(nums);
        System.out.println(nums);
        System.out.println(num);
    }
}
