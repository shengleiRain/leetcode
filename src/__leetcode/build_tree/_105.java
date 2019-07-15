package __leetcode.build_tree;

import structure.tree.BinaryTree;
import structure.tree.Tree;
import structure.tree.TreeNode;

/**
 * @author Rain
 * @date 2019/7/14.
 */
public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int inorderStart, int inorderEnd) {

        if (preorderStart >= preorder.length || inorderStart > inorderEnd) {
            return null;
        }

        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        // 记录rootVal在inorder中的位置
        int count = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) break;
            count++;
        }

        root.left = buildTree(preorder, inorder, preorderStart + 1, inorderStart, inorderStart + count - 1);
        root.right = buildTree(preorder, inorder, preorderStart + count + 1, inorderStart + count + 1, inorderEnd);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        TreeNode root = new _105().buildTree(preorder, inorder);
        Tree tree = new BinaryTree();
        tree.preOrderTraverse(root);
        System.out.println();
        tree.middleOrderTraverse(root);
    }
}
