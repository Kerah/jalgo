package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.trifle.OpTracker;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonSorterTest {
    static Comparable[] reversed(int size) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - i - 1;
        }
        return a;
    }

    static Comparable[] sorted(int size) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        return a;
    }

    static OpTracker trackedReversedTest(Sorter sorter, int size) {
        OpTracker tracker = new OpTracker();
        sorter.setTracker(tracker);
        sorter.sort(reversed(size));
        return tracker;
    }
    static OpTracker trackeSortedTest(Sorter sorter, int size) {
        OpTracker tracker = new OpTracker();
        sorter.setTracker(tracker);
        sorter.sort(sorted(size));
        return tracker;
    }
}
