package net.redpandaz.lab.jalgo.alg.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;

public class QuickUnion implements UnionFind {
    private Field field;

    QuickUnion(Field field){
        this.field = field;
    }

    public QuickUnion(int length) {
        field = new Field(length);
    }


    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        field.setID(pRoot, qRoot);
        field.modCount(1);
    }

    @Override
    public int find(int p) {
        while (p != field.getId(p)) p = field.getId(p);
        return p;
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
