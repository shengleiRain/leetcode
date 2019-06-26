package __leetcode;

import java.util.Random;

/**
 * @author Rain
 * @date 2019/6/26.
 */
public class _215 {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        while (low < high) {
            int pivot = findPivot(nums, low, high);
            if (pivot < k) {
                low = pivot + 1;
            } else if (pivot > k) {
                high = pivot - 1;
            } else {
                break;
            }
        }
        return nums[k];

    }

    private int findPivot(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                Utils.swap(nums, i, j);
                i++;
            }
        }
        Utils.swap(nums, i, end);
        return i;
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        return findKthLargest2(nums, 0, len - 1, len - k);
    }

    //k is 0-based
    private int findKthLargest2(int[] nums, int start, int end, int k) {
        if (start == end) return nums[k];

        int left = start, right = end;
        int mid = (left + right) / 2;
        int pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left++, right--);
            }
        }
        // right+1=left
        if (k <= right) {
            return findKthLargest2(nums, start, right, k);
        }
        if (k >= left) {
            return findKthLargest2(nums, left, end, k);
        }
        return nums[k];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new _215().findKthLargest2(nums, k));
    }
}
