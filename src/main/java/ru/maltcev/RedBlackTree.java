package ru.maltcev;

public class RedBlackTree {

    /**
     * @param root корневой узел, от которого начинается проверка
     * @return проверяет сбалансированость дерева, идет проверка на симметричность, так как, по-момему, именно это
     *          обозначает сбалансированость
     */
    public static boolean checkLengthOfBranch(RBNode root) {

        if (root.getLeft() == null)
            return root.getRight() == null;

        return lengthDetermination(root) != -1;
    }

    private static int lengthDetermination(RBNode node) {

        int currentLeft = 0;
        int currentRight = 0;
        int current = node.isRed()?  0 : 1;

        if (node.getLeft() != null)
            currentLeft = lengthDetermination(node.getLeft());

        if (node.getRight() != null)
            currentRight = lengthDetermination(node.getRight());

        if(currentLeft == -1 || currentLeft != currentRight)     //(currentLeft == -1)  уже не требуется
            return -1;

        return currentLeft + currentRight + current;
    }
}
