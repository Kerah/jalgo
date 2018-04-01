package net.redpandaz.lab.jalgo.api;

public interface Queue<Item> {
    void enqueue(Item item);
    Item dequeu();
    boolean isEmpty();
    int size();
}
