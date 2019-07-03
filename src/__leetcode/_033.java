package __leetcode;

import binarySearch.BinarySearch;

/**
 * @author Rain
 * @date 2019/7/2.
 */
public class _033 {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {//前半段有序
                if (nums[left] <= target && target < nums[mid]) {
                    return BinarySearch.findAny(nums, left, mid - 1, target);
                } else {
                    left = mid + 1;
                }
            } else {//后半段有序
                if (target > nums[mid] && target<=nums[right]) {
                    return BinarySearch.findAny(nums, mid + 1, right, target);
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(search(nums, 2));
    }
}
