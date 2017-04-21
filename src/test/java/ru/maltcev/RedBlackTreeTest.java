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

    @Test
    public void test1() {

        RBNodeTest<Integer> root  = new RBNodeTest<>(10);
        RBNodeTest<Integer> node6 = new RBNodeTest<>(6);
        RBNodeTest<Integer> node17 = new RBNodeTest<>(17,true);
        RBNodeTest<Integer> node13 = new RBNodeTest<>(13,true);
        RBNodeTest<Integer> node3 = new RBNodeTest<>(3,true);
        RBNodeTest<Integer> node8 = new RBNodeTest<>(8,true);
        RBNodeTest<Integer> node15 = new RBNodeTest<>(15);
        RBNodeTest<Integer> node2 = new RBNodeTest<>(2);
        RBNodeTest<Integer> node4 = new RBNodeTest<>(4);
        RBNodeTest<Integer> node7 = new RBNodeTest<>(7);
        RBNodeTest<Integer> node9 = new RBNodeTest<>(9);
        RBNodeTest<Integer> node12 = new RBNodeTest<>(12);
        RBNodeTest<Integer> node14 = new RBNodeTest<>(14);
        RBNodeTest<Integer> node16 = new RBNodeTest<>(16);
        RBNodeTest<Integer> node18 = new RBNodeTest<>(18);

        root.setLeft(node6);
        node6.setRight(node8);
        node6.setLeft(node3);
        node3.setRight(node4);
        node3.setLeft(node2);
        node8.setRight(node9);
        node8.setLeft(node7);

        root.setRight(node15);
        node15.setRight(node17);
        node15.setLeft(node13);
        node13.setRight(node12);
        node13.setLeft(node14);
        node17.setRight(node18);
        node17.setLeft(node16);

        assertTrue(checkLengthOfBranch(root));
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