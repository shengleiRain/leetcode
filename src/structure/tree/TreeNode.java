package structure.tree;

/**
 * @author Rain
 * @date 2019/7/3.
 * 树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
