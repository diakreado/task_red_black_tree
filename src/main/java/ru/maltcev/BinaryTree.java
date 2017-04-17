package ru.maltcev;

import com.sun.istack.internal.NotNull;

import java.util.*;

// Attention: comparable supported but comparator is not
@SuppressWarnings("WeakerAccess")
public class BinaryTree<T extends Comparable<T>> extends AbstractSet<T> {

    private static class Node<T> {
        final T value;

        Node<T> left = null;

        Node<T> right = null;

        Node(T value) {
            this.value = value;
        }

        Node<T> parent = null;
    }

    private Node<T> root = null;

    private int size = 0;

    @Override
    public boolean add(T t) {
        Node<T> closest = find(t);
        int comparison = closest == null ? -1 : closest.value.compareTo(t);
        if (comparison == 0) {
            return false;
        }
        Node<T> newNode = new Node<>(t);
        if (closest == null) {
            root = newNode;
            newNode.parent = root;
        }
        else if (comparison < 0) {
            assert closest.left == null;
            closest.left = newNode;
            newNode.parent = closest;
        }
        else {
            assert closest.right == null;
            closest.right = newNode;
            newNode.parent = closest;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        Node<T> closest = find(t);
        return closest != null && t.compareTo(closest.value) == 0;
    }

    private Node<T> find(T value) {
        if (root == null) return null;
        return find(root, value);
    }

    private Node<T> find(Node<T> start, T value) {
        int comparison = start.value.compareTo(value);
        if (comparison == 0) {
            return start;
        }
        else if (comparison < 0) {
            if (start.left == null) return start;
            return find(start.left, value);
        }
        else {
            if (start.right == null) return start;
            return find(start.right, value);
        }
    }

    public class BinaryTreeIterator implements Iterator<T> {

        private Node<T> current = null;
        private Stack<Node<T>> nodeStack = new Stack<>();
        private T maxValue = null;
        private Set<T> pathItem = new HashSet<>();
        private boolean isRigthPart = true;

        private BinaryTreeIterator() {}

        private void findFirst() {
            current = root;
            while (current.right!=null) {
                nodeStack.push(current);
                current = current.right;
            }
            maxValue = current.value;
        }

        public Node<T> findNext() {

            if(current == null) {
                findFirst();
                pathItem.add(current.value);
                return current;
            }
            pathItem.add(current.value);

            if(current.right != null && !pathItem.contains(current.right.value)) {

                current = current.right;

                while (current.right != null)
                    current = current.right;

                return current;
            }
            if(current.left != null && !pathItem.contains(current.left.value)) {

                current = current.left;

                while (current.right != null)
                    current = current.right;

                return current;
            }

            while (pathItem.contains(current.parent.value))
                current = current.parent;

            return current.parent;
        }

        @Override
        public boolean hasNext() {
            return findNext() != null;
        }

        @Override
        public T next() {
            current = findNext();
            if (current == null) throw new NoSuchElementException();
            return current.value;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator();
    }

    @Override
    public int size() {
        return size;
    }
}