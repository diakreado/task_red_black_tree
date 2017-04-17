package ru.maltcev;

import org.junit.Test;
import java.util.Iterator;

import static org.junit.Assert.*;


public class BinaryTreeTest {

    @Test
    public void test() {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(10);
        tree.add(5);
        tree.add(13);
        tree.add(3);
        tree.add(12);
        tree.add(7);
        tree.add(16);
        tree.add(20);
        tree.add(1);
        tree.add(18);
        tree.add(2);
        tree.add(50);
        tree.add(11);

        BinaryTree.BinaryTreeIterator iterator = (BinaryTree.BinaryTreeIterator) tree.iterator();

        Integer expectedValues[] = {1,2,3,5,7,10,11,12,13,16,18,20,50};

        for (int i = 0; i < tree.size(); i++) {
            assertTrue(iterator.next().compareTo(expectedValues[i]) == 0);
        }
    }
}