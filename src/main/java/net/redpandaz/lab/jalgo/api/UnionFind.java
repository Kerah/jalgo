package net.redpandaz.lab.jalgo.api;

public interface UnionFind {
    void union(int p, int q);
    int find(int p);
    boolean connected(int p, int q);
    int count();
}
