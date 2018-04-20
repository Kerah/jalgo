package net.redpandaz.lab.jalgo.impl.commons;

public class Pair<Item> {
    private Item left;
    private Item right;

    public Pair(Item left, Item right) {
        this.left = left;
        this.right = right;
    }

    public Item getLeft() {
        return left;
    }

    public void setLeft(Item left) {
        this.left = left;
    }

    public Item getRight() {
        return right;
    }

    public void setRight(Item right) {
        this.right = right;
    }
}
