package ua.ithillel.jcf.tree;

import java.util.*;

public class TreeUtil {

    public static <V> boolean breadthFirstSearch(TreeNode<V> root, V value) {
        Queue<TreeNode<V>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<V> first = queue.remove();

            if (first.getValue() == value || first.getValue().equals(value)) {
                return true;
            }

            if (first.getLeft() != null) {
                queue.add(first.getLeft());
            }

            if (first.getRight() != null) {
                queue.add(first.getRight());
            }
        }


        return false;
    }

    public static <V> boolean depthFirstSearch(TreeNode<V> root, V value) {
        Stack<TreeNode<V>> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<V> top = stack.pop();

            V val = top.getValue();
            if (val == value || val.equals(value)) {
                return true;
            }

            if (top.getRight() != null) {
                stack.push(top.getRight());
            }

            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }
        }


        return false;
    }

    public static <V> List<V> breadthFirst(TreeNode<V> root) {
        List<V> values = new ArrayList<>();
        Queue<TreeNode<V>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<V> first = queue.remove();

            values.add(first.getValue());

            if (first.getLeft() != null) {
                queue.add(first.getLeft());
            }

            if (first.getRight() != null) {
                queue.add(first.getRight());
            }
        }


        return values;
    }

    public static <V> List<V> depthFirst(TreeNode<V> root) {
        List<V> values = new ArrayList<>();
        Stack<TreeNode<V>> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<V> top = stack.pop();

            V value = top.getValue();
            values.add(value);

            if (top.getRight() != null) {
                stack.push(top.getRight());
            }

            if (top.getLeft() != null) {
                stack.push(top.getLeft());
            }
        }


        return values;
    }

    public static <V> List<V> depthFirstRecurse(TreeNode<V> root) {
        // base case
        if (root == null) {
            return new ArrayList<>();
        }

        // recursive case
        List<V> left = depthFirstRecurse(root.getLeft());
        List<V> right = depthFirstRecurse(root.getRight());

        return new ArrayList<>() {{
           add(root.getValue());
           addAll(left);
           addAll(right);
        }};
    }
}
