package net.redpandaz.lab.jalgo.practices.containers_1_3.api;

import net.redpandaz.lab.jalgo.api.Stack;

public interface StackedQueue<Item> extends Stack<Item>, Iterable<Item> {
    void enqueue(Item item);
}
