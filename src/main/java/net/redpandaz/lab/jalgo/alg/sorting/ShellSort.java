package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.trifle.DNTracker;

public class ShellSort implements Sorter {
    private Tracker tracker;

    ShellSort() {
        tracker = new DNTracker();
    }

    ShellSort(Tracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while ( h < N/3) h = 3*h+1;
        while (h >=1){
            tracker.incIterates();
            for (int i = h; i < N; i++) {
                tracker.incIterates();
                tracker.incCompares();
                for (int j = i; j >= h && lesser(a[j], a[j-h]); j -= h) {
                    tracker.incCompares();
                    tracker.incIterates();
                    tracker.incMoves();
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }
    }

    @Override
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
