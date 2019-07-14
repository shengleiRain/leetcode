package structure.tree;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public class Test {

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();
        tree.addNode(5);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(6);
        tree.addNode(4);
        tree.addNode(7);
        tree.addNode(10);
        tree.middleOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.println(tree.inOrderTraversal(tree.getRoot()));

        tree.preOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.println(tree.preOrderTraversal(tree.getRoot()));


    }
}
