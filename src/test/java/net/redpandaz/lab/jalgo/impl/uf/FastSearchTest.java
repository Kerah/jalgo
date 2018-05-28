package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.trifle.OpTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FastSearchTest extends UnionFindTest {
    @Test
    void checkCorrectCaseSuite() {
        TenFieldTest(new FastSearch(10));
    }

    @Test
    void checkStatsOFTenFieldTest() {
        FastSearch fs = new FastSearch(100);
        OpTracker fsTracker = new OpTracker();
        OpTracker checkTracker = new OpTracker();

        HundredFieldTestStatsOnLastStep(fs, fsTracker);
        assertEquals(0, fsTracker.getAllocates());
        assertEquals(100, fsTracker.getIterates());
        assertEquals(101, fsTracker.getCompares());
        assertEquals(99, fsTracker.getMoves());
        assertEquals(300, fsTracker.total());

        fs.setTracker(checkTracker);;
        fs.connected(0, 1);

        assertEquals(0, checkTracker.getAllocates());
        assertEquals(0, checkTracker.getIterates());
        assertEquals(1, checkTracker.getCompares());
        assertEquals(0, checkTracker.getMoves());
        assertEquals(1, checkTracker.total());
    }
}