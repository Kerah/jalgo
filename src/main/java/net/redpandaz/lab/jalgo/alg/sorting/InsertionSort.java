package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.trifle.DNTracker;

public class InsertionSort implements Sorter, Trackable {
    private Tracker tracker;

    InsertionSort() {
        tracker = new DNTracker();
    }

    InsertionSort(Tracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void sort(Comparable[] a) {
        int N  = a.length;

        for (int i=1; i < N; i++) {
            tracker.incIterates();
            tracker.incCompares();
            for (int j= i; j > 0 && lesser(a[j], a[j-1]); j--) {
                tracker.incIterates();
                tracker.incMoves();
                tracker.incCompares();
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
