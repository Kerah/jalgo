package net.redpandaz.lab.jalgo.trifle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class StopWatchTest {
    @Test
    void elapsedCheck() throws Exception {
        StopWatch sw = new StopWatch();
        TimeUnit.SECONDS.sleep(1);
        double elapsed = sw.elapsedTime();
        assertEquals(1, Math.round(elapsed));
    }

}