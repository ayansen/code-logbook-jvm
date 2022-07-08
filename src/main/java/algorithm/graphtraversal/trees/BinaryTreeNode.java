package algorithm.graphtraversal.trees;

/**
 * Created by aysen on 10/2/16.
 */
public class BinaryTreeNode<T> extends TreeNode<T> {


    public BinaryTreeNode(T data) {
        super(data);
    }


    public BinaryTreeNode(T data, BinaryTreeNode<T> parent) {
        super(data, parent);
    }


    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> left;


    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
        addChild(right);
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        addChild(left);
    }


}
