package ua.ithillel.jcf.tree;

import java.util.Iterator;
import java.util.Stack;

public class TreeNode<V> implements Iterable<V> {
    private final V value;
    private TreeNode<V> left;
    private TreeNode<V> right;

    public TreeNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<V> left) {
        this.left = left;
    }

    public TreeNode<V> getRight() {
        return right;
    }

    public void setRight(TreeNode<V> right) {
        this.right = right;
    }

    @Override
    public Iterator<V> iterator() {
        return new DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<V> {
        private Stack<TreeNode<V>> stack = new Stack<>();

        public DepthFirstIterator() {
            stack.add(TreeNode.this);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public V next() {
            TreeNode<V> top = stack.pop();

            if (top.getRight() != null) {
                stack.push(top.getRight());
            }

            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }

            return top.value;
        }
    }
}
