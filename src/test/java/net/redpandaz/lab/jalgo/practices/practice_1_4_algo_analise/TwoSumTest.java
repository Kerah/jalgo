package net.redpandaz.lab.jalgo.practices.practice_1_4_algo_analise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void brute_force() {
        int[] a = {3,2,1,0,-1};
        assertEquals(1, TwoSum.withBruteForce(a));
    }

    @Test
    void binary_search() {
        int[] a = {3,2,1,0,-1};
        assertEquals(1, TwoSum.withBinarySearch(a));
    }
}