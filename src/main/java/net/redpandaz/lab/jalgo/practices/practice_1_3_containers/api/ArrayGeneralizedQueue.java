package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.api;

import net.redpandaz.lab.jalgo.api.Array;
import net.redpandaz.lab.jalgo.impl.commons.ResizableArray;

// practice 1.3.38 - implementation in resizable array
public class ArrayGeneralizedQueue<Item> implements GeneralizedQueue<Item> {
    Array<Item> items = new ResizableArray<>();

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void insert(Item item) {
        items.add(item);
    }

    @Override
    public Item delete(int index) {
        return items.delete(index);
    }
}
