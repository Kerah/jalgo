package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickUnionTest {
    @Test
    void checkTenScenario() {
        UnionFindTest.TenFieldTest(new QuickUnion(10));
    }

    @Test
    void checkStatsOFTenFieldTest() {
        UnionFind fs = new QuickUnion(100);
        OpTracker connectTracker = new OpTracker();
        OpTracker checkTracker = new OpTracker();

        UnionFindTest.HundredFieldTestStatsOnLastStep(fs, connectTracker);
        assertEquals(0, connectTracker.getAllocates());
        assertEquals(0, connectTracker.getIterates());
        assertEquals(1, connectTracker.getCompares());
        assertEquals(1, connectTracker.getMoves());
        assertEquals(2, connectTracker.total());

        ((QuickUnion) fs).setTracker(checkTracker);
        fs.connected(0, 1);

        assertEquals(0, checkTracker.getAllocates());
        assertEquals( 197, checkTracker.getIterates());
        assertEquals(198, checkTracker.getCompares());
        assertEquals(0, checkTracker.getMoves());
        assertEquals(395, checkTracker.total());
    }

}