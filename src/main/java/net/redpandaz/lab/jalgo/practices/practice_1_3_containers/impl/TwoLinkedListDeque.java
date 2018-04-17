package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.impl;

import net.redpandaz.lab.jalgo.api.Deque;
import net.redpandaz.lab.jalgo.impl.commons.TwoLinkedNode;

// practice 1.3.33
public class TwoLinkedListDeque<Item> implements Deque<Item> {
    private TwoLinkedNode<Item> firstLeft, firstRight;
    private int currentSize = 0;

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void pushLeft(Item item) {
        firstLeft = new TwoLinkedNode<>(item).asRight(firstLeft);
        if (currentSize == 0) firstRight = firstLeft;
        currentSize++;
    }

    @Override
    public void pushRight(Item item) {
        firstRight = new TwoLinkedNode<>(item).asLeft(firstRight);
        if (currentSize == 0) firstLeft = firstRight;
        currentSize++;
    }

    @Override
    public Item popLeft() {
        TwoLinkedNode<Item> tmp = firstLeft;
        firstLeft = firstLeft.getRight();
        currentSize--;
        if (isEmpty()) firstRight = null;
        else firstLeft.asLeft(null);

        tmp.asRight(null);

        return tmp.getItem();
    }

    @Override
    public Item popRight() {
        TwoLinkedNode<Item> tmp = firstRight;
        firstRight = firstRight.getLeft();
        currentSize--;
        if (isEmpty()) firstLeft = null;
        else firstRight.asLeft(null);

        tmp.asLeft(null);

        return tmp.getItem();
    }
}
