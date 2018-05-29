package net.redpandaz.lab.jalgo.api;

import java.util.Arrays;

public interface Sorter extends Trackable {
    void sort(Comparable[] a);
    default boolean lesser(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    default void exch(Comparable[] a, int i, int j ) {
        Comparable buffer = a[i];
        a[i]= a[j];
        a[j] = buffer;
    }

    default boolean isSorted(Comparable[] a) {
        for (int i = 1; i<a.length; i++)
            if (!lesser(a[i-1], a[i])) return false;
        return true;
    }

    default boolean check(Comparable[] a) {
        Comparable[] b = a.clone();
        sort(a);
        Arrays.sort(b);

        int N = a.length;
        for (int i=0; i<N; i++)
            if (a[i] != b[i]) return false;
        return true;
    }
}
