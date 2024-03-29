package offer;

import structure.tree.TreeNode;

/**
 * @author Rain
 * @date 2019/7/16.
 * <p>
 * 树的子结构
 * <p>
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1, root2) ||
                HasSubtree(root1.left, root2) ||
                HasSubtree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
        } else {
            return false;
        }
    }

}
