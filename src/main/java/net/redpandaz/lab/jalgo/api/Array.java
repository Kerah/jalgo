package net.redpandaz.lab.jalgo.api;

public interface Array<Item> extends Iterable<Item> {
    int size();
    boolean isEmpty();
    void add(Item item);
    Item delete(int index);
    Item get(int index);
    Item pop();
}
