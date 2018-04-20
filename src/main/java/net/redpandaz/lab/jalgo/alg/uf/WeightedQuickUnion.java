package net.redpandaz.lab.jalgo.alg.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;

public class WeightedQuickUnion implements UnionFind {
    private Field field;
    private Sizer sizer;
    private int total;

    public WeightedQuickUnion(int total) {
        this.total = total;
        field = new Field(total);
        sizer = new Sizer(total);
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sizer.get(i) < sizer.get(j)) {
            field.setID(i, j);
            sizer.set(i, sizer.get(j));
        } else {
            field.setID(j, i);
            sizer.set(j, sizer.get(i));
        }
        field.modCount(1);
    }

    @Override
    public int find(int p) {
        while (p != field.getId(p)) p = field.getId(p);
        return p;
    }

    @Override
    public int count() {
        return field.getCount();
    }

    class Sizer {
        private int[] field;

        Sizer(int total) {
            field = new int[total];
            for (int i = 0; i < total; i++) {
                field[i] = 1;
            }
        }

        public int get(int index) {
            return field[index];
        }

        public void set(int index, int value) {
            field[index] = value;
        }

        public void incr(int index) {
            field[index]++;
        }
    }
}
