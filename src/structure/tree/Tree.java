package structure.tree;

import java.util.List;

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
     * 前序遍历，非递归方式
     *
     * @param root
     * @return
     */
    List<Integer> preOrderTraversal(TreeNode root);

    /**
     * 中序遍历
     *
     * @param root
     */
    void middleOrderTraverse(TreeNode root);

    /**
     * 中序遍历，非递归方式
     *
     * @param root
     * @return
     */
    List<Integer> inOrderTraversal(TreeNode root);

    /**
     * 后序遍历
     *
     * @param root
     */
    void postOrderTraverse(TreeNode root);

    /**
     * 后序遍历，非递归方式
     */
    List<Integer> postOrderTraversal(TreeNode root);

    /**
     * 层序遍历
     */
    void levelOrderTraverse(TreeNode root);

    /**
     * 求一棵树的高度
     */
    int treeHeight(TreeNode root);

    /**
     * 求一棵树的高度，非递归方法
     */
    int getTreeHeight(TreeNode root);
}
