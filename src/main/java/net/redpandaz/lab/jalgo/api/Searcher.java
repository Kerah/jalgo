package net.redpandaz.lab.jalgo.api;

public interface Searcher<Item> {
    int Search(Item value, Array<Item> items);
}
