package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Stack<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int currentSize = 0;

    @Override
    public void push(Item item) {
        if (currentSize == items.length) resize(items.length * 2);
        items[currentSize++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--currentSize];

        items[currentSize] = null;
        if (currentSize > 0 && currentSize == items.length / 4) resize(items.length / 2);
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

    void resize(int max) {
        // move stack items to new array with size eq max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < currentSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {

        return new StackIterator(this);
    }
}
