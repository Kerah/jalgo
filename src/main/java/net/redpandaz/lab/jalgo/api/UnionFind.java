package net.redpandaz.lab.jalgo.api;

public interface UnionFind {
    void union(int p, int q);
    int find(int p);
    default boolean connected(int p, int q) {
        return find(p) == find(q);
    };
    int count();
}
