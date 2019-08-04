package offer;

import java.util.*;


/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 1) {
            return true;
        }
        int index;
        int rootValue = sequence[sequence.length - 1];
        for (index = sequence.length - 2; index >= 0; index--) {
            if (sequence[index] < rootValue) {
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            if (sequence[i] > rootValue) {
                return false;
            }
        }
        boolean left = (index <= 0) || VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
        boolean right = (index == sequence.length - 2) || VerifySquenceOfBST(Arrays.copyOfRange(sequence, index + 1, sequence.length - 1));
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{7, 4, 6, 5}));
    }
}
