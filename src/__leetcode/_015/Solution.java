package __leetcode._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rain on 2019/5/25.
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int remain = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {

                if (nums[j] + nums[k] == remain) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) ++j;
                    while (j < k && nums[k - 1] == nums[k]) --k;
                    ++j;
                    --k;
                } else if (nums[j] + nums[k] < remain) ++j;
                else {
                    --k;
                }
            }
        }
        return result;
    }

    public static int threeSumCLosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) throw new RuntimeException("params is error.");
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int diffAbs = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++) {
//            if (3*nums[i])
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (sum < target) {
                    ++j;
                } else {
                    --k;
                }
                if (Math.abs(sum-target)<diffAbs){
                    result=sum;
                    diffAbs=Math.abs(sum-target);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4, -1, -1, 0, -1, -4, 2, 3};
//        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists);

        int[] nums = {-1, 2, 1, -4};
        int num = threeSumCLosest(nums, 1);
        System.out.println(num);
    }
}
