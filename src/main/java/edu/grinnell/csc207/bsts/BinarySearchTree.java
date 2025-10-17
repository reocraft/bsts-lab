package edu.grinnell.csc207.bsts;

import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading

    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        /**
         * @param value the value of the node
         * @param left the left child of the node
         * @param right the right child of the node
         */
        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * @param node the root of the tree
     * @return the number of elements in the specified tree
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in this tree
     */
    public int size() {
        return sizeH(root);
    }

    /**
     * @param value the value to add to the tree
     */
    public void insert(T value) {
        // throw new UnsupportedOperationException();
        if (this.root == null) {
            this.root = new Node<T>(value);
            return;
        }
        insertH(this.root, value);
    }

    public void insertH(Node<T> tr, T value) {

        if (value.compareTo(tr.value) < 0) {
            if (tr.left == null) {
                tr.left = new Node<T>(value);
            } else {
                insertH(tr.left, value);
            }
        }
        else {
            if (tr.right == null) {
                tr.right = new Node<T>(value);
            } else {
                insertH(tr.right, value);
            }
        }
    }

    ///// Part 1: Contains
   
    /**
     * @param v the value to find
     * @return true iff this tree contains <code>v</code>
     */
    public boolean contains(T v) {
        // throw new UnsupportedOperationException();
        return containsH(root, v);
    }

    public boolean containsH(Node<T> node, T v) {
        if (node == null) {
            return false;
        }
        else if (node.value.equals(v)) {
            return true;
        } 
        if (v.compareTo(node.value) < 0) {
            return containsH(node.left, v);
        }
        else {
            return containsH(node.right, v);
        }
    }


    ///// Part 2: Ordered Traversals

    /**
     * @return the (linearized) string representation of this BST
     */
    @Override
    public String toString() {
        // throw new UnsupportedOperationException();
        StringBuffer sb = new StringBuffer("[");
        toStringH(root, sb);
        if (!sb.toString().equals("[")) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public void toStringH(Node<T> node, StringBuffer sb) {
        if (node == null) {
            return;
        }
        toStringH(node.left, sb);
        sb.append(node.value);
        sb.append(", ");
        toStringH(node.right, sb);
    }

    /**
     * @return a list contains the elements of this BST in-order.
     */
    public List<T> toList() {
        throw new UnsupportedOperationException();
    }

    ///// Part 3: BST Sorting

    /**
     * @param <T> the carrier type of the lists
     * @param lst the list to sort
     * @return a copy of <code>lst</code> but sorted
     * @implSpec <code>sort</code> runs in ___ time if the tree remains balanced. 
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> lst) {
        throw new UnsupportedOperationException();
    }

    ///// Part 4: Deletion
  
    /*
     * The three cases of deletion are:
     * 1. (TODO: fill me in!)
     * 2. (TODO: fill me in!)
     * 3. (TOOD: fill me in!)
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code> found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        throw new UnsupportedOperationException();
    }
}
