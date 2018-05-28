package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightedQuickUnionTest {
    @Test
    void checkCorrectTenTest() {
        UnionFindTest.TenFieldTest(new WeightedQuickUnion(10));
    }

    @Test
    void checkStatsOFTenFieldTest() {
        UnionFind uf = new WeightedQuickUnion(100);
        OpTracker connectTracker = new OpTracker();
        OpTracker checkTracker = new OpTracker();

        UnionFindTest.HundredFieldTestStatsOnLastStep(uf, connectTracker);
        assertEquals(0, connectTracker.getAllocates());
        assertEquals(1, connectTracker.getIterates());
        assertEquals(3, connectTracker.getCompares());
        assertEquals(1, connectTracker.getMoves());
        assertEquals(5, connectTracker.total());

        ((WeightedQuickUnion) uf).setTracker(checkTracker);
        uf.connected(0, 1);

        assertEquals(0, checkTracker.getAllocates());
        assertEquals(1, checkTracker.getIterates());
        assertEquals(2, checkTracker.getCompares());
        assertEquals(0, checkTracker.getMoves());
        assertEquals(3, checkTracker.total());
    }
}