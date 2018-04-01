package net.redpandaz.lab.jalgo.api;

public interface Bag<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}

