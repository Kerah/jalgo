package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.trifle.DNTracker;

public class SelectionSort implements Sorter, Trackable {
    private Tracker tracker;
    SelectionSort(){
        tracker  = new DNTracker();
    }
    SelectionSort(Tracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i < N; i++) {
            tracker.incIterates();
            int min  = i;
            for (int j= i+1; j < N; j++) {
                tracker.incIterates();
                tracker.incCompares();
                if (lesser(a[j], a[min])) min = j;

            }
            tracker.incMoves();
            exch(a, i, min);
        }
    }

    @Override
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
