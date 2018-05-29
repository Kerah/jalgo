package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        Comparable[] a = CommonSorterTest.reversed(10);
        Sorter sorter = new InsertionSort();
        sorter.sort(a);

        assertTrue(sorter.isSorted(a));

        sorter.sort(a);
        assertTrue(sorter.isSorted(a));
    }

    @Test
    void trackable10Reversed() {
        OpTracker tracker =CommonSorterTest.trackedReversedTest(new InsertionSort(), 10);
        assertEquals(0, tracker.getAllocates());
        assertEquals(54, tracker.getCompares());
        assertEquals(54, tracker.getIterates());
        assertEquals(45, tracker.getMoves());
        assertEquals(153, tracker.total());
    }

    @Test
    void trackable100Reversed() {
        OpTracker tracker = CommonSorterTest.trackedReversedTest(new InsertionSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(5049, tracker.getCompares());
        assertEquals(5049, tracker.getIterates());
        assertEquals(4950, tracker.getMoves());
        assertEquals(15048, tracker.total());
    }

    @Test
    void trackable10Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new InsertionSort(), 10);

        assertEquals(0, tracker.getAllocates());
        assertEquals(9, tracker.getCompares());
        assertEquals(9, tracker.getIterates());
        assertEquals(0, tracker.getMoves());
        assertEquals(18, tracker.total());
    }

    @Test
    void trackable100Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new InsertionSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(99, tracker.getCompares());
        assertEquals(99, tracker.getIterates());
        assertEquals(0, tracker.getMoves());
        assertEquals(198, tracker.total());
    }
}