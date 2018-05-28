package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WeightedQuickUnionWithCompressTest {
    @Test
    void testCorrectPass10Test() {
        UnionFind uf = new WeightedQuickUnionWithCompress(10);
        UnionFindTest.TenFieldTest(uf);
        Set<Integer> set = new HashSet<>();
        Field field = ((WeightedQuickUnionWithCompress) uf).field;
        for (int i=0; i<10; i++) {
            set.add(field.getId(i));
        }
        assertEquals(1, set.size());
        assertTrue(set.contains(6));
    }
}