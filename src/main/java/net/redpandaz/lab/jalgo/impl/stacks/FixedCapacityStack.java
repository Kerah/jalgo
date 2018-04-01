package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Stack;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Stack<Item> {

    private Item[] items;
    private int stackedElements;

    public FixedCapacityStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    @Override
    public void push(Item item) {
        items[stackedElements++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--stackedElements];
        items[stackedElements] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return stackedElements == 0;
    }

    @Override
    public int size() {
        return stackedElements;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(this);
    }
}
