package net.redpandaz.lab.jalgo.practices.practice_1_4_algo_analise;

import net.redpandaz.lab.jalgo.impl.commons.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class TwoPairSumTest {
    private int[] items;

    @BeforeEach
    void tearUp(){
        items = new int[]{10, 9, 8, 6, 5, 4, 0};
    }

    @Test
    void byValueWithPairOnSides() {
        Pair<Integer> result = TwoPairSum.byValue(items, 10);
        assertNotNull(result);
        assertEquals(0, result.getLeft().intValue());
        assertEquals(10, result.getRight().intValue());
    }

    @Test
    void byValueWithPairOnMiddle() {
        Pair<Integer> result = TwoPairSum.byValue(items, 11);
        assertNotNull(result);
        assertEquals(5, result.getLeft().intValue());
        assertEquals(6, result.getRight().intValue());
    }

    @Test
    void byValueWithoutResult() {
        assertNull(TwoPairSum.byValue(items, 42));
    }
}