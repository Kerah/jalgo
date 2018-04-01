package net.redpandaz.lab.jalgo.api;

public interface Bag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}

