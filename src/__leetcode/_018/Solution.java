package __leetcode._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rain on 2019/6/3.
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length >= 4) {
            // 排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                while (i > 0 && nums[i - 1] == nums[i]) ++i;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int remain = target - nums[i] - nums[j];
                    int r = j + 1, l = nums.length - 1;
                    while (r < l) {
                        if (remain == nums[r] + nums[l]) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[r], nums[l]));
                            while (r < l && nums[r + 1] == nums[r]) ++r;
                            while (r < l && nums[l - 1] == nums[l]) --l;
                            ++r;
                            --l;
                        } else if (nums[r] + nums[l] < remain) {
                            ++r;
                        } else {
                            --l;
                        }
                    }
                    while (nums[j] == nums[j + 1] && j < nums.length - 2) ++j;//去重
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
