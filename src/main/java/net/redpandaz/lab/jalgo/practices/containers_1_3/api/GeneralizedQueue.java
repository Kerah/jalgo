package net.redpandaz.lab.jalgo.practices.containers_1_3.api;

public interface GeneralizedQueue<Item> {
    boolean isEmpty();
    int size();
    void insert(Item item);
    Item delete(int index);
}
