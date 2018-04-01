package net.redpandaz.lab.jalgo.impl.queues;

import net.redpandaz.lab.jalgo.api.Queue;
import net.redpandaz.lab.jalgo.impl.commons.LinkedNode;

public class LinkedListQueue<Item> implements Queue<Item> {
    private LinkedNode<Item> first, last;
    private int currentSize;

    @Override
    public void enqueue(Item item) {
        last = new LinkedNode<>(item).nextNodeFor(last);
        if (currentSize == 0) first = last;
        currentSize ++;
    }

    @Override
    public Item dequeu() {
        Item item = first.getItem();
        first = first.getNextNode();
        currentSize--;
        if (isEmpty() ) last =null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        boolean value = currentSize == 0;

        return value;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
