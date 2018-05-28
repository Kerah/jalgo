package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;

public class WeightedQuickUnion extends QuickUnion {
    private Sizer sizer;

    public WeightedQuickUnion(int total) {
        super(total);
        sizer = new Sizer(total);
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        tracker.incCompares();
        if (i == j) return;
        tracker.incCompares().incMoves();
        if (sizer.get(i) < sizer.get(j)) {
            field.setID(i, j);
            sizer.set(i, sizer.get(j));
        } else {
            field.setID(j, i);
            sizer.set(j, sizer.get(i));
        }
        field.modCount(1);
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
