package __leetcode._136;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rain on 2019/5/28.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num:nums) {
            if (set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        return (int) set.toArray()[0];
    }
    public static void main(String[] args){
        int[] nums={2,2,1,4,4};
        System.out.println(new Solution().singleNumber(nums));
    }
}
