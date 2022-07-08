package algorithm.graphtraversal.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysen on 10/18/16.
 */
public class TreeNode<T> {

    private boolean root;
    private boolean leaf;
    private final TreeNode<T> parent;
    private final T data;
    private final List<TreeNode<T>> nodes;

    public TreeNode(T data) {
        this.parent = this;
        this.data = data;
        nodes = new ArrayList<>();
        root = true;
        leaf = true;
    }

    public TreeNode(T data, TreeNode<T> parent) {
        this.parent = parent;
        this.data = data;
        nodes = new ArrayList<>();
        root = false;
        leaf = true;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public boolean isRoot() {
        return root;
    }

    public void addChild(TreeNode<T> node) {
        nodes.add(node);
    }

    public boolean isLeaf() {
        return leaf;
    }

    public List<TreeNode<T>> getChildren() {
        return nodes;
    }
}
