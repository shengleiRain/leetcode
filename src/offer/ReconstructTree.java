package offer;

import structure.tree.BinaryTree;
import structure.tree.Tree;
import structure.tree.TreeNode;

/**
 * @author Rain
 * @date 2019/7/15.
 * -------------------------------------------------------------------------------------
 * 重建二叉树
 * -------------------------------------------------------------------------------------
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * -------------------------------------------------------------------------------------
 */
public class ReconstructTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return helper(pre, in, 0, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int count = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                break;
            }
            count++;
        }
        root.left = helper(pre, in, preStart + 1, inStart, inStart + count - 1);
        root.right = helper(pre, in, preStart + count + 1, inStart + count + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ReconstructTree().reConstructBinaryTree(
                new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        Tree tree = new BinaryTree();
        tree.preOrderTraverse(root);
        System.out.println();
        tree.middleOrderTraverse(root);
    }
}
