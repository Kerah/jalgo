package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.DNTracker;

public class FastSearch implements UnionFind, Trackable {
    private Tracker tracker;

    private Field field;
    private int length;
    public FastSearch(int count) {
        field = new Field(count);
        length = count;
        tracker = new DNTracker();
    }

    @Override
    public void union(int p, int q) {
        int pID = field.getId(p);
        int qID = field.getId(q);

        tracker.incCompares();
        if (pID == qID) return;

        for (int i =0 ; i < length; i++) {
            tracker.incIterates();
            tracker.incCompares();
            if (field.getId(i) == pID) {
                tracker.incMoves();
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
