package net.redpandaz.lab.jalgo.alg.sorting;

import net.redpandaz.lab.jalgo.api.Sorter;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    void sort() {
        Comparable[] a = CommonSorterTest.reversed(10);
        Sorter sorter = new ShellSort();
        sorter.sort(a);

        assertTrue(sorter.isSorted(a));

        sorter.sort(a);
        assertTrue(sorter.isSorted(a));
    }

    @Test
    void trackable10Reversed() {
        OpTracker tracker =CommonSorterTest.trackedReversedTest(new ShellSort(), 10);
        assertEquals(0, tracker.getAllocates());
        assertEquals(28, tracker.getCompares());
        assertEquals(30, tracker.getIterates());
        assertEquals(13, tracker.getMoves());
        assertEquals(71, tracker.total());
    }

    @Test
    void trackable100Reversed() {
        OpTracker tracker = CommonSorterTest.trackedReversedTest(new ShellSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(572, tracker.getCompares());
        assertEquals(576, tracker.getIterates());
        assertEquals(230, tracker.getMoves());
        assertEquals(1378, tracker.total());
    }

    @Test
    void trackable10Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new ShellSort(), 10);

        assertEquals(0, tracker.getAllocates());
        assertEquals(15, tracker.getCompares());
        assertEquals(17, tracker.getIterates());
        assertEquals(0, tracker.getMoves());
        assertEquals(32, tracker.total());
    }

    @Test
    void trackable100Sorted() {
        OpTracker tracker = CommonSorterTest.trackeSortedTest(new ShellSort(), 100);
        assertEquals(0, tracker.getAllocates());
        assertEquals(342, tracker.getCompares());
        assertEquals(346, tracker.getIterates());
        assertEquals(0, tracker.getMoves());
        assertEquals(688 , tracker.total());
    }
}