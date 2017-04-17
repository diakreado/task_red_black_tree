package ru.maltcev;

public interface RBNode<T> {

    T getValue();
    default boolean isRed() {
        return true;
    }

    RBNode<T> getLeft();
    RBNode<T> getRight();

    void setLeft(RBNode<T> left);
    void setRight(RBNode<T> right);
    void setColor(boolean isRed);
}