package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Track;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        Comparable[] a = CommonSorterTest.reversed(10);
        Sorter sorter = new SelectionSort();
        sorter.sort(a);

        assertTrue(sorter.isSorted(a));

        sorter.sort(a);
        assertTrue(sorter.isSorted(a));
    }

    @Test
    void trackable10Reversed() {
        OpTracker tracker =CommonSorterTest.trackedReversedTest(new SelectionSort(), 10);
        assertEquals(0, tracker.getAllocates());
        assertEquals(45, tracker.getCompares());
        assertEquals(55, tracker.getIterates());
        assertEquals(10, tracker.getMoves());
        assertEquals(110, tracker.total());
    }

    @Test
    void trackable100Reversed() {
        OpTracker tracker = CommonSorterTest.trackedReversedTest(new SelectionSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(4950, tracker.getCompares());
        assertEquals(5050, tracker.getIterates());
        assertEquals(100, tracker.getMoves());
        assertEquals(10100, tracker.total());
    }

    @Test
    void trackable10Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new SelectionSort(), 10);

        assertEquals(0, tracker.getAllocates());
        assertEquals(45, tracker.getCompares());
        assertEquals(55, tracker.getIterates());
        assertEquals(10, tracker.getMoves());
        assertEquals(110, tracker.total());
    }

    @Test
    void trackable100Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new SelectionSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(4950, tracker.getCompares());
        assertEquals(5050, tracker.getIterates());
        assertEquals(100, tracker.getMoves());
        assertEquals(10100, tracker.total());
    }
}