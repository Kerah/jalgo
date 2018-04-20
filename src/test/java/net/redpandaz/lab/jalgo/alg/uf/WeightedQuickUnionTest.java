package net.redpandaz.lab.jalgo.alg.uf;

import org.junit.jupiter.api.Test;

class WeightedQuickUnionTest {
    @Test
    void checkCorrectTenTest() {
        UnionFindTest.TenFieldTest(new WeightedQuickUnion(10));
    }
}