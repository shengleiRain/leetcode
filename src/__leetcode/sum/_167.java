package __leetcode.sum;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/7/14.
 * Two Sum II - Input array is sorted
 * --------------------------------------------------------------------------------------------------------
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * --------------------------------------------------------------------------------------------------------
 */
public class _167 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _167().twoSum(new int[]{5, 25, 75}, 100)));
    }
}
