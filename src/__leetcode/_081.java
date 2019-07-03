package __leetcode;

import binarySearch.BinarySearch;

/**
 * @author Rain
 * @date 2019/7/2.
 */
public class _081 {
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid] || nums[right] < nums[mid]) {//前半段有序或者后半段无序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right] || nums[left] > nums[mid]) {//后半段有序或者前半段无序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }

    public static boolean findAny(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 2, 2};
        System.out.println(search(nums, 10));
    }
}
