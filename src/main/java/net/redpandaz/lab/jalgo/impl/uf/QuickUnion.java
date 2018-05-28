package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.DNTracker;

public class QuickUnion implements UnionFind, Trackable {
    protected Tracker tracker;
    protected Field field;

    public QuickUnion(int length) {
        field = new Field(length);
        this.tracker = new DNTracker();
    }


    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        tracker.incCompares();
        if (pRoot == qRoot) return;
        tracker.incMoves();
        field.setID(pRoot, qRoot);
        field.modCount(1);
    }

    @Override
    public int find(int p) {
        while (p != field.getId(p)) {
            tracker.incCompares().
                    incIterates();
            p = field.getId(p);
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        tracker.incCompares();
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return field.getCount();
    }

    @Override
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
