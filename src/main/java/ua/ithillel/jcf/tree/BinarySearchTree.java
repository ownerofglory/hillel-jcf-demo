package ua.ithillel.jcf.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<V> implements SearchTree<V> {
    private Node<V> root;
    private Comparator<V> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<V> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean search(V value) {
        Node<V> curNode = root;
        int cmp = 0;
        if (comparator != null) {
            while (curNode != null) {
                cmp = comparator.compare(curNode.value, value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                   return true;
                }
            }
        } else {
            while (curNode != null) {
                Comparable<V> vComparable = (Comparable<V>) curNode.value;
                cmp = vComparable.compareTo(value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void insert(V value) {
        Node<V> valueNode = new Node<>(value);

        insertNode(valueNode);
    }

    private void insertNode(Node<V> valueNode) {
        if (root == null) {
            root = valueNode;
            return;
        }

        Node<V> curNode = root;
        Node<V> parent = curNode;
        int cmp = 0;
        if (comparator != null) {
            while (curNode != null) {
                parent = curNode;
                cmp = comparator.compare(curNode.value, valueNode.value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                    return;
                }
            }
        } else {
            while (curNode != null) {
                parent = curNode;
                Comparable<V> vComparable = (Comparable<V>) curNode.value;
                cmp = vComparable.compareTo(valueNode.value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                    return;
                }
            }
        }

        if (cmp > 0) {
            parent.left = valueNode;
        } else {
            parent.right = valueNode;
        }

        valueNode.parent = parent;
    }

    @Override
    public void delete(V value) {
        Node<V> curNode = root;
        int cmp = 0;
        if (comparator != null) {
            while (curNode != null) {
                cmp = comparator.compare(curNode.value, value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                    deleteNode(curNode);
                    return;
                }
            }
        } else {
            while (curNode != null) {
                Comparable<V> vComparable = (Comparable<V>) curNode.value;
                cmp = vComparable.compareTo(value);
                if (cmp > 0) {
                    curNode = curNode.left;
                } else if (cmp < 0) {
                    curNode = curNode.right;
                } else {
                    deleteNode(curNode);
                    return;
                }
            }
        }
    }

    private void deleteNode(Node<V> node) {
        Node<V> parent = node.parent;
        if (parent == null) {
            root = null;
            insertSubTree(node.left);
            insertSubTree(node.right);
        } else {
            int cmp = 0;
            if (comparator != null) {
                cmp = comparator.compare(parent.value, node.value);
            } else {
                Comparable<V> vComparable = (Comparable<V>) parent.value;
                cmp = vComparable.compareTo(node.value);
            }

            if (cmp > 0) {
                // parent is bigger
                // delete left side
                parent.left = null;
                insertSubTree(node.left);
                insertSubTree(node.right);
            } else {
                parent.right = null;
                insertSubTree(node.left);
                insertSubTree(node.right);
            }
        }
    }

    private void insertSubTree(Node<V> subTree) {
        if (subTree == null) {
            return;
        }

        Node<V> vNode = new Node<>(subTree.value);
        insertNode(vNode);

        insertSubTree(subTree.left);
        insertSubTree(subTree.right);
    }

    @Override
    public Iterator<V> iterator() {
        return new DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<V> {
        private Stack<Node<V>> stack = new Stack<>();

        public DepthFirstIterator() {
            stack.add(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public V next() {
            Node<V> top = stack.pop();

            if (top.right != null) {
                stack.push(top.right);
            }

            if (top.left != null) {
                stack.push(top.left);
            }

            return top.value;
        }
    }

    private class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;
        Node<V> parent;

        public Node(V value) {
            this.value = value;
        }
    }
}
