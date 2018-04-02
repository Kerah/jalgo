package net.redpandaz.lab.jalgo.practices.containers_1_3.orig;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JosephusTest {
    @Test
    void checkCorrectElemnts() {
        Josephus joseph = new Josephus(7, 2);
        int[] expected = {1, 3, 5, 0, 4, 2, 6};
        int[] values = joseph.steps();
        assertArrayEquals(expected, expected);
    }
}