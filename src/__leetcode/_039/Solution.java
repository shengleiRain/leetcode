package __leetcode._039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rain on 2019/5/27.
 */
public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> cur=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null||candidates.length==0) return null;
        Arrays.sort(candidates);
        find(candidates,0,target);
        return result;
    }

    void find(int[] candidates,int start,int target){
        if (target==0){
            result.add(new ArrayList<>(cur));
        }else if (target>0){
            for (int i = start; i < candidates.length; i++) {
                cur.add(candidates[i]);
                find(candidates,i,target-candidates[i]);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums={2,6,3,7};
        System.out.println(new Solution().combinationSum(nums,7)) ;
    }
}
