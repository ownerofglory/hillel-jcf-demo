package ua.ithillel.jcf.map;

import java.util.Comparator;

public class MyTreeMap<K, V> implements MyMap<K, V> {
    private TreeNode<Entry<K, V>> root;
    private Comparator<K> comparator;

    public MyTreeMap() {
    }

    public MyTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        TreeNode<Entry<K, V>> newNode = new TreeNode<>(newEntry);

        if (root == null) {
            root = newNode;
            return;
        }

        putNode(newNode);

    }

    private void putNode(TreeNode<Entry<K, V>> newNode) {
        var curNode = root;
        var parent = curNode;
        int cmp = 0;

        if (root == null) {
            root = newNode;
            return;
        }

        if (comparator == null) {
            while (curNode != null) {
                parent = curNode;
                Comparable<K> comparableKey = (Comparable<K>) newNode.entry.key;
                cmp = comparableKey.compareTo(curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    curNode.entry.value = newNode.entry.value;
                    return;
                }
            }
        } else {
            while (curNode != null) {
                parent = curNode;
                cmp = comparator.compare(newNode.entry.key, curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    curNode.entry.value = newNode.entry.value;
                    return;
                }
            }
        }

        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;
    }

    private void putSubTree(TreeNode<Entry<K, V>> node) {
        if (node == null) {
            return;
        }

        TreeNode<Entry<K, V>> newNode = new TreeNode<>(node.entry);
        putNode(newNode);
        putSubTree(node.left);
        putSubTree(node.right);
    }
    @Override
    public V get(K key) {
        var curNode = root;
        int cmp = 0;
        if (comparator == null) {
            while (curNode != null) {
                Comparable<K> comparableKey = (Comparable<K>) key;
                cmp = comparableKey.compareTo(curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    return curNode.entry.value;
                }
            }
        } else {
            while (curNode != null) {
                cmp = comparator.compare(key, curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    return curNode.entry.value;
                }
            }
        }


        return null;
    }

    @Override
    public void remove(K key) {
        var curNode = root;
        int cmp = 0;
        if (comparator == null) {
            while (curNode != null) {
                Comparable<K> comparableKey = (Comparable<K>) key;
                cmp = comparableKey.compareTo(curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    break;
                }
            }
        } else {
            while (curNode != null) {
                cmp = comparator.compare(key, curNode.entry.key);
                if (cmp < 0) {
                    curNode = curNode.left;
                } else if (cmp > 0) {
                    curNode = curNode.right;
                } else {
                    break;
                }
            }
        }

        if (curNode == null) {
            return;
        }

        TreeNode<Entry<K, V>> parent = curNode.parent;

        if (parent != null) {
            if (comparator == null) {
                Comparable<K> comparableKey = (Comparable<K>) key;
                cmp = comparableKey.compareTo(parent.entry.key);
            } else {
                cmp = comparator.compare(key, parent.entry.key);
            }

            if (cmp < 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            root = null;
        }

        putSubTree(curNode.left);
        putSubTree(curNode.right);

    }

    private class TreeNode<T> {
        T entry;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        public TreeNode(T entry) {
            this.entry = entry;
        }
    }

    private class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
