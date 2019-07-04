package structure.tree;

/**
 * @author Rain
 * @date 2019/7/3.
 * 树节点
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
