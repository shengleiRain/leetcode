package __leetcode.sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Rain
 * @date 2019/7/14.
 * <p>
 * <p>
 * 1. Two Sum
 * --------------------------------------------------------------------------------------------------------
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * --------------------------------------------------------------------------------------------------------
 */
public class _001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j;
            if (map.containsKey(target - nums[i]) && (j = map.get(target - nums[i])) != i) {
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _001().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
