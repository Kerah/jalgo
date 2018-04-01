package net.redpandaz.lab.jalgo.impl.commons;

import java.util.Iterator;

public class LinkedNodeIterator<Item> implements Iterator<Item> {
    private LinkedNode<Item> current;

    public LinkedNodeIterator(LinkedNode<Item> node) {
        current = node;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        if (!hasNext()) return null;
        Item item = current.getItem();
        current = current.getNextNode();
        return item;
    }

    @Override
    public void remove() {

    }
}