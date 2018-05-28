package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionWithCompressTest {
    @Test
    void testCorrectPass10Test() {
        UnionFind uf = new QuickUnionWithCompress(10);
        UnionFindTest.TenFieldTest(uf);
        Set<Integer> set = new HashSet<>();
        Field field = ((QuickUnionWithCompress) uf).field;
        for (int i=0; i<10; i++) {
            set.add(field.getId(i));
        }
        assertEquals(1, set.size());
        assertTrue(set.contains(8));
    }

    @Test
    void checkStatsOFTenFieldTest() {
        UnionFind fs = new QuickUnionWithCompress(100);
        OpTracker connectTracker = new OpTracker();
        OpTracker checkTracker = new OpTracker();

        UnionFindTest.HundredFieldTestStatsOnLastStep(fs, connectTracker);
        assertEquals(0, connectTracker.getAllocates());
        assertEquals(0, connectTracker.getIterates());
        assertEquals(1, connectTracker.getCompares());
        assertEquals(1, connectTracker.getMoves());
        assertEquals(2, connectTracker.total());

        ((QuickUnionWithCompress) fs).setTracker(checkTracker);
        fs.connected(0, 1);

        assertEquals(0, checkTracker.getAllocates());
        assertEquals(4, checkTracker.getIterates());
        assertEquals(5, checkTracker.getCompares());
        assertEquals(0, checkTracker.getMoves());
        assertEquals(9, checkTracker.total());
    }
}