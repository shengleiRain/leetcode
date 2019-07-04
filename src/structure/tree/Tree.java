package structure.tree;

import structure.ListNode;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public interface Tree {

    /**
     * 新增节点
     *
     * @param value
     */
    void addNode(int value);

    /**
     * 删除节点
     *
     * @param value
     */
    void removeNode(int value);

    TreeNode findNode(int value);

    /**
     * 前序遍历
     *
     * @param root
     */
    void preOrderTraverse(TreeNode root);

    /**
     * 中序遍历
     *
     * @param root
     */
    void middleOrderTraverse(TreeNode root);

    /**
     * 后序遍历
     *
     * @param root
     */
    void postOrderTraverse(TreeNode root);

    /**
     * 层序遍历
     */
    void levelOrderTraverse(TreeNode root);
}
