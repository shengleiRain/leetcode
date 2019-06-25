package __leetcode._169;

/**
 * Created by Rain on 2019/5/26.
 */
public class Solution {

    public static int majorityElement(int[] nums) {
        if(nums.length<=0) throw new RuntimeException("params is error.");
        int count=0;
        int result=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (result==nums[i]) count++;
            else if (count==0){
                result=nums[i];
                count=1;
            }else{
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
