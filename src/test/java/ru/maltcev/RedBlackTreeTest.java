package ru.maltcev;

import org.junit.Test;

import static ru.maltcev.RedBlackTree.checkLengthOfBranch;
import static org.junit.Assert.*;


public class RedBlackTreeTest {

    @Test
    public void test() {

        RBNodeTest<Integer> root = new RBNodeTest<>(10);
        RBNodeTest<Integer> node3 = new RBNodeTest<>(3);
        RBNodeTest<Integer> node5 = new RBNodeTest<>(5, true);
        RBNodeTest<Integer> node7 = new RBNodeTest<>(7);
        RBNodeTest<Integer> node12 = new RBNodeTest<>(12);
        RBNodeTest<Integer> node13 = new RBNodeTest<>(13, true);
        RBNodeTest<Integer> node16 = new RBNodeTest<>(16);

        root.setLeft(node5);
        node5.setRight(node7);
        node5.setLeft(node3);
        root.setRight(node13);
        node13.setLeft(node12);
        node13.setRight(node16);

        assertTrue(checkLengthOfBranch(root));

        RBNodeTest<Integer> node20 = new RBNodeTest<>(20);

        node16.setRight(node20);

        assertFalse(checkLengthOfBranch(root));
    }

    class RBNodeTest<T> implements RBNode<T> {

        private T value;
        private RBNode<T> left = null;
        private RBNode<T> right = null;
        private boolean isRed = false;

        RBNodeTest(T value) {
            this.value = value;
        }

        RBNodeTest(T value, boolean isRed) {
            this.value = value;
            this.isRed = isRed;
        }

        @Override
        public T getValue() {
            return null;
        }

        @Override
        public RBNode<T> getLeft() {
            return left;
        }

        @Override
        public RBNode<T> getRight() {
            return right;
        }

        @Override
        public void setLeft(RBNode<T> left) {
            this.left = left;
        }

        @Override
        public void setRight(RBNode<T> right) {
            this.right = right;
        }

        @Override
        public void setColor(boolean isRed) {
            this.isRed = isRed;
        }

        @Override
        public boolean isRed() {
            return isRed;
        }
    }
}