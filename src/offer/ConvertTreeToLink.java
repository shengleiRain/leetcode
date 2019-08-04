package offer;

import structure.tree.TreeNode;

import java.util.Stack;


/**
 * ��Ŀ����
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class ConvertTreeToLink {

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode node = pRootOfTree;
        TreeNode result = null;
        while (node != null || !stack.isEmpty()) {
            // ���ڵ���ջ
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
            // �������right�ڵ�
            node = cur.right;
        }
        return result;
    }
}
