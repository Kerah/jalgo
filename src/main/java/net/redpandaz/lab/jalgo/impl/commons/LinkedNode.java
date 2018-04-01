package net.redpandaz.lab.jalgo.impl.commons;

public class LinkedNode<Item> {
    protected Item item;
    protected LinkedNode<Item> nextNode;

    public LinkedNode(Item item) {
        this.item = item;
    }

    public LinkedNode<Item> nextNodeFor(LinkedNode<Item> node) {
        if (node != null) {
            node.nextNode = this;
        }
        return this;
    }

    public Item getItem() {
        return item;
    }

    public LinkedNode<Item> getNextNode() {
        return nextNode;
    }
}
