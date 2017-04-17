package ru.maltcev;

public class RedBlackTree {

    public static boolean checkLengthOfBranch(RBNode root) {

        if (root.getLeft() == null)
            return root.getRight() == null;

        lengthDetermination(root);

        return isConditionFulfilled;
    }

    private static boolean isConditionFulfilled = true;

    private static int lengthDetermination(RBNode node) {

        int currentLeft = 0;
        int currentRight = 0;

        if (node.getLeft() != null) {

            currentLeft = lengthDetermination(node.getLeft());

            if (!node.getLeft().isRed())
                currentLeft++;
        }

        if (node.getRight() != null) {

            currentRight = lengthDetermination(node.getRight());

            if (!node.getRight().isRed())
                currentRight++;
        }

        if(currentLeft != currentRight)
            isConditionFulfilled = false;

        return currentLeft + currentRight;
    }

}
