package net.redpandaz.lab.jalgo.impl.commons;

import java.util.Iterator;

public class ArrayIterator<Item> implements Iterator<Item>{
    private Item[] items;
    private int cursor;
    private int currentLength;

    public ArrayIterator(Item[] items, int currentSize) {
        this.items = items;
        this.currentLength = currentSize;
    }


    @Override
    public boolean hasNext() {
        return cursor < currentLength;
    }

    @Override
    public Item next() {
        return items[cursor++];
    }
}
