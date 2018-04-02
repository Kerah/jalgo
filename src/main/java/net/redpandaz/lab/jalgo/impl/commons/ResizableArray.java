package net.redpandaz.lab.jalgo.impl.commons;

import net.redpandaz.lab.jalgo.api.Array;

import java.util.Iterator;

public class ResizableArray<Item> implements Array<Item> {
    private Item[] items = (Item[]) new Object[1];
    int currentSize;
    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }

    @Override
    public void add(Item item) {
        if (currentSize == items.length) resize(items.length * 2);
        items[currentSize++] = item;
    }

    private void resize(int max) {
        // move stack items to new array with size eq max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < currentSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Item delete(int index) {
        Item item = items[index];
        for (int i = index; i < currentSize; i ++) {
            int j = i+1;
            if (j < currentSize) items[i] = items[j];
        }
        items[--currentSize] = null;
        if (currentSize > 0 && currentSize == items.length / 4) resize(items.length / 2);
        return item;
    }

    @Override
    public Item get(int index) {
        return items[index];
    }

    @Override
    public Item pop() {
        return delete(currentSize-1);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator<>(items, currentSize);
    }
}
