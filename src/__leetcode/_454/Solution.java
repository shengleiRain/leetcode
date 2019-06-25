package __leetcode._454;

import java.util.HashMap;

/**
 * Created by Rain on 2019/6/3.
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length==0) return 0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>(A.length*B.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum=A[i]+B[j];
                if (map.containsKey(sum)) map.replace(sum,map.get(sum)+1);
                else map.put(sum,1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum=C[i]+D[j];
                if (map.containsKey(-sum)) count+=map.get(-sum);
            }
        }
        return count;
    }

    private int[] items=new int[10];

    public void add(int value){
        final int[] copyItems=this.items;
        copyItems[0]=value;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        solution.add(10);
        System.out.println(solution.items[0]);
    }
}
