package net.redpandaz.lab.jalgo.impl.commons;

public class TwoLinkedNode<Item> {
    private TwoLinkedNode<Item> left, right;
    private Item item;

    public TwoLinkedNode(Item item) {
        this.item = item;
    }

    public TwoLinkedNode<Item> getLeft() {
        return left;
    }

    public void setLeft(TwoLinkedNode<Item> left) {
        this.left = left;
    }

    public TwoLinkedNode<Item> getRight() {
        return right;
    }

    public void setRight(TwoLinkedNode<Item> right) {
        this.right = right;
    }

    public Item getItem() {
        return item;
    }

    public TwoLinkedNode<Item> asRight(TwoLinkedNode<Item> node) {
        if (node != null) {
            if (right != null) node.right = right;
            node.left = this;
        }
        right = node;
        return this;
    }

    public TwoLinkedNode<Item> asLeft(TwoLinkedNode<Item> node) {
        if (node != null) {
            if (left != null) node.left = left;
            node.right = this;
        }
        left = node;
        return this;
    }
}
