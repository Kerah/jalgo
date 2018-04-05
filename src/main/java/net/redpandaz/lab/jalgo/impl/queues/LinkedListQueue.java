package net.redpandaz.lab.jalgo.impl.queues;

import net.redpandaz.lab.jalgo.api.Queue;
import net.redpandaz.lab.jalgo.impl.commons.LinkedNode;

public class LinkedListQueue<Item> implements Queue<Item> {
    private LinkedNode<Item> first, last;
    private int currentSize;
    public LinkedListQueue() {

    }
    // practice 1.3.41
    public LinkedListQueue(Queue<Item> from) {
        for (int i= 0; i < from.size(); i++) {
            Item item = from.dequeu();
            from.enqueue(item);
            enqueue(item);
        }
    }

    @Override
    public void enqueue(Item item) {
        last = new LinkedNode<>(item).nextNodeFor(last);
        if (currentSize == 0) first = last;
        currentSize++;
    }

    @Override
    public Item dequeu() {
        Item item = first.getItem();
        first = first.getNextNode();
        currentSize--;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
