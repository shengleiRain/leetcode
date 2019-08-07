package offer;

import structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Rain
 * @date 2019/8/6.
 * <p>
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 */
public class ZipPrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int count = 0;
        stack1.push(pRoot);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ArrayList<Integer> item = new ArrayList<>();
            if (count % 2 == 0) {
                while (!stack1.isEmpty()) {
                    TreeNode pop = stack1.pop();
                    item.add(pop.val);
                    if (pop.left != null) {
                        stack2.push(pop.left);
                    }
                    if (pop.right != null) {
                        stack2.push(pop.right);
                    }
                }
                result.add(item);
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode pop = stack2.pop();
                    item.add(pop.val);
                    if (pop.right != null) {
                        stack1.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack1.push(pop.left);
                    }
                }
                result.add(item);
            }
        }
        return result;
    }
}
