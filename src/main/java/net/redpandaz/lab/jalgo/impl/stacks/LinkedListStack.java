package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Stack;

import java.util.Iterator;

public class LinkedListStack<Item> implements Stack<Item>{
    private Node<Item> first;
    private int currentSize;

    @Override
    public void push(Item item) {
        Node<Item> cursor = first;
        first = new Node<>(item);
        first.nextNode = cursor;
        currentSize ++;
    }

    @Override
    public Item pop() {
        Node<Item> cursor = first;
        first = cursor.nextNode;
        cursor.nextNode = null;
        currentSize--;
        return cursor.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(this);
    }

    private class  Node<Item> {
        Node(Item item) {
            this.item = item;
        }
        protected Item item;
        protected Node<Item> nextNode;
    }
}
