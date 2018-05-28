package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.Trackable;
import net.redpandaz.lab.jalgo.api.Tracker;
import net.redpandaz.lab.jalgo.api.UnionFind;
import net.redpandaz.lab.jalgo.trifle.DNTracker;
import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {
    static void HundredFieldTestStatsOnLastStep(UnionFind uf, Tracker connect) {
        int i = 1;
        for (; i < 99; i ++) {
            uf.union(i-1, i);
        }

        if (uf instanceof Trackable) {
            Trackable trackable = (Trackable)uf;
            trackable.setTracker(connect);
        }
        uf.union(i-1, i);

        if (uf instanceof Trackable) {
            Trackable trackable = (Trackable)uf;
            trackable.setTracker(new DNTracker());
        }

        for (i = 0; i < 100; i++) {
            for (int j = 1; j < 10; j++) {
                connected(uf, i, j);
            }
        }
        assertEquals(1, uf.count());
    }
    static void TenFieldTest(UnionFind uf) {
        unconnected(uf,4, 3);
        unconnected(uf,3, 8);
        unconnected(uf,6, 5);
        unconnected(uf,9, 4);
        unconnected(uf,2, 1);
        connected(uf,8, 9);
        unconnected(uf,5, 0);
        unconnected(uf,7, 2);
        unconnected(uf,6, 1);
        connected(uf,1, 0);
        connected(uf,6, 7);
        unconnected(uf,7, 8);

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                connected(uf, i, j);
            }
        }
        assertEquals(1, uf.count());
    }

    static void connected(UnionFind uf, int p, int q) {
        assertTrue(uf.connected(p, q));

    }

    static void unconnected(UnionFind uf, int p, int q) {
        assertFalse(uf.connected(p, q));
        uf.union(p, q);
    }
    @Test
    void checkStatsOFTenFieldTest() {
        QuickUnion fs = new QuickUnion(10);
        OpTracker fsTracker = new OpTracker();

        fs.setTracker(fsTracker);
        TenFieldTest(fs);
        assertEquals(0, fsTracker.getAllocates());
        assertEquals(340, fsTracker.getIterates());
        assertEquals(349, fsTracker.getCompares());
        assertEquals(9, fsTracker.getMoves());
    }
}
