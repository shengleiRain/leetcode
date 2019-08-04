package offer;

import structure.tree.TreeNode;

import java.util.Stack;


/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTreeToLink {

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode node = pRootOfTree;
        TreeNode result = null;
        while (node != null || !stack.isEmpty()) {
            // 将节点入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            if (result == null) {
                result = cur;
            }
            prev = cur;
            // 如果还有right节点
            node = cur.right;
        }
        return result;
    }
}
