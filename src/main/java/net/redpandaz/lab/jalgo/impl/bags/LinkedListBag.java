package net.redpandaz.lab.jalgo.impl.bags;

import net.redpandaz.lab.jalgo.api.Bag;
import net.redpandaz.lab.jalgo.impl.commons.LinkedNode;
import net.redpandaz.lab.jalgo.impl.commons.LinkedNodeIterator;

import java.util.Iterator;

public class LinkedListBag<Item> implements Bag<Item> {
    private LinkedNode<Item> first;
    private LinkedNode<Item> last;
    int currentSize;

    @Override
    public void add(Item item) {
        last = new LinkedNode<>(item).nextNodeFor(last);
        if (currentSize == 0) first = last;
        currentSize++;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedNodeIterator<>(first);
    }
}
