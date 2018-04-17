package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.api;

import net.redpandaz.lab.jalgo.api.Stack;

public interface StackedQueue<Item> extends Stack<Item>, Iterable<Item> {
    void enqueue(Item item);
}
