package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.impl;

import net.redpandaz.lab.jalgo.api.Deque;

// 1.3.33
public class ArrayDequeu<Item> implements Deque<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int currentSize;

    private void resize(int max, boolean moveToRight) {
        // move stack items to new array with size eq max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < currentSize; i++) {
            int j = i;
            if (moveToRight) j++;

            temp[j] = items[i];
        }
        items = temp;
    }

    private void moveToLeft() {
        for (int i = 1; i < currentSize; i++) {
            items[i-1] = items[i];
        }
    }

    private void leftResize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 1; i < currentSize+1; i++) {
            temp[i-1] = items[i];
        }
        items = temp;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private void moveToRight() {
        Item buffer = null;
        Item current = null;
        for (int i = 0; i < currentSize; i++) {
            current = items[i];
            items[i] = buffer;
            int j = i+1;
            if (j > items.length) break;;

            buffer = items[j];
            items[j] = current;
        }
    }

    @Override
    public void pushLeft(Item item) {
        if (currentSize == items.length) resize(items.length * 2, true);
        else  if (currentSize != 0) moveToRight();
        items[0] = item;
        currentSize++;
    }

    @Override
    public void pushRight(Item item) {
        if (currentSize == items.length) resize(items.length * 2, false);
        items[currentSize++] = item;
    }

    @Override
    public Item popLeft() {
        Item item = items[0];
        currentSize--;
        int max = currentSize;
        if (currentSize > 0 && currentSize == items.length / 4) max = items.length / 2;

        if (max > 0) leftResize(max);
        else moveToLeft();
        return item;
    }

    @Override
    public Item popRight() {
        Item item = items[--currentSize];
        items[currentSize] = null;
        if (currentSize > 0 && currentSize == items.length / 4) resize(items.length / 2, false);
        return item;
    }
}
