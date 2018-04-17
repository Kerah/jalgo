package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.impl;

import net.redpandaz.lab.jalgo.api.Queue;

public class RingBuffer<Item> implements Queue<Item> {
    private int size;
    private int cursor;
    private int currentSize;
    private Item[] items;

    RingBuffer(int size) {
        items = (Item[]) new Object[size];
        this.size = size;
    }

    @Override
    public void enqueue(Item item) {
        if (currentSize == size) throw new ArrayIndexOutOfBoundsException();
        int putIn = cursor++%size;
        items[putIn] = item;
        currentSize++;
    }

    @Override
    public Item dequeu() {
        int putAt = cursor%size;//5
        if (putAt >= currentSize) putAt = putAt - currentSize;
        int startFrom = currentSize-putAt;//



        --currentSize;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
