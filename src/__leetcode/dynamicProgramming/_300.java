package __leetcode.dynamicProgramming;

import java.util.*;

/**
 * @author Rain
 * @date 2019/6/19.
 */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        List<Integer> maxSeq = new ArrayList<>();
        for (int num : nums) {
            if (maxSeq.size() == 0) {
                maxSeq.add(num);
                continue;
            }
            int replaceIndex= binarySearch(maxSeq,num);
            if (replaceIndex==maxSeq.size()){
                maxSeq.add(num);
            }else{
                maxSeq.set(replaceIndex,num);
            }

        }
        return maxSeq.size();
    }

    private int binarySearch(List<Integer> maxSeq, int num) {
        int start=0;
        int end=maxSeq.size()-1;
        while (start <= end) {
            int middle= (end + start) / 2;
            if (num < maxSeq.get(middle)) {
                end = middle - 1;
            } else if (num > maxSeq.get(middle)) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new _300().lengthOfLIS(nums));
        System.out.println(new _300().lengthOfLIS2(nums));
//        List<Integer> nums2 = Arrays.asList(11,12,14,15);
//        System.out.println(new _300().binarySearch(nums2,16));
    }
}
