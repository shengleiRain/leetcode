package offer;

import structure.tree.TreeNode;

/**
 * @author Rain
 * @date 2019/8/6.
 * <p>
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmeticTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return helper(pRoot.left, pRoot.right);

    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }


}
