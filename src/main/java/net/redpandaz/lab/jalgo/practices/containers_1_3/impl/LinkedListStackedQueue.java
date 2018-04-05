package net.redpandaz.lab.jalgo.practices.containers_1_3.impl;

import net.redpandaz.lab.jalgo.impl.commons.LinkedNode;
import net.redpandaz.lab.jalgo.impl.stacks.StackIterator;
import net.redpandaz.lab.jalgo.practices.containers_1_3.api.StackedQueue;

import java.util.Iterator;

// practice 1.3.32
public class LinkedListStackedQueue<Item> implements StackedQueue<Item> {
    private LinkedNode<Item> first;
    private LinkedNode<Item> last;
    private int currentSize;
    @Override
    public void enqueue(Item item) {
        last = new LinkedNode<>(item).nextNodeFor(last);
        if (currentSize == 0) first = last;
        currentSize++;
    }

    @Override
    public void push(Item item) {
        first = new LinkedNode<>(item).setNextNode(first);
        if (currentSize  == 0) last = first;
        currentSize ++;
    }

    @Override
    public Item pop() {
        Item item = first.getItem();
        first = first.getNextNode();
        currentSize--;
        if (isEmpty()) {last = null;}
        return item;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(this);
    }
}
