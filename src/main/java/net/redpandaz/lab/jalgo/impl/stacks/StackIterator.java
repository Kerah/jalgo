package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Stack;

import java.util.Iterator;

public class StackIterator<Item> implements Iterator<Item> {
    Stack<Item> itemStack;

    public StackIterator(Stack<Item> items) {
        itemStack = items;
    }

    @Override
    public boolean hasNext() {
        return itemStack.size() > 0;
    }

    @Override
    public Item next() {
        return itemStack.pop();
    }

    @Override
    public void remove() {

    }
}
