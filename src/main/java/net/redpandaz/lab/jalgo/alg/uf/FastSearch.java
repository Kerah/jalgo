package net.redpandaz.lab.jalgo.alg.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;

public class FastSearch implements UnionFind {
    private Field field;
    private int length;
    public FastSearch(int count) {
        field = new Field(count);
        length = count;
    }

    @Override
    public void union(int p, int q) {
        int pID = field.getId(p);
        int qID = field.getId(q);

        if (pID == qID) return;

        for (int i =0 ; i < length; i++) {
            if (field.getId(i) == pID) {
                field.setID(i, qID);
            }
        }
        field.modCount(1);
    }

    @Override
    public int find(int p) {
        return field.getId(p);
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return field.getCount();
    }
}
