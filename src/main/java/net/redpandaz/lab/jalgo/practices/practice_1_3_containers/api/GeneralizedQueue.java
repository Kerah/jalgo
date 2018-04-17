package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.api;

public interface GeneralizedQueue<Item> {
    boolean isEmpty();
    int size();
    void insert(Item item);
    Item delete(int index);
}
