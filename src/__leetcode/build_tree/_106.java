package __leetcode.build_tree;

import structure.tree.BinaryTree;
import structure.tree.Tree;
import structure.tree.TreeNode;

/**
 * @author Rain
 * @date 2019/7/14.
 */
public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, postorder, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postEnd, int inorderStart, int inorderEnd) {
        if (postEnd < 0 || inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int leftCount = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            leftCount++;
        }
        int rightCount = inorderEnd - inorderStart - leftCount;
        root.left = buildTree(inorder, postorder, postEnd - rightCount - 1, inorderStart, inorderStart + leftCount - 1);
        root.right = buildTree(inorder, postorder, postEnd - 1, inorderStart + leftCount + 1, inorderEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new _106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Tree tree = new BinaryTree();
        tree.middleOrderTraverse(root);
        System.out.println();
        tree.postOrderTraverse(root);
    }
}
