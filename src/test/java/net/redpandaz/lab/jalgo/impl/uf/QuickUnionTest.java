package net.redpandaz.lab.jalgo.impl.uf;

import org.junit.jupiter.api.Test;

class QuickUnionTest {
    @Test
    void checkTenScenario() {
        UnionFindTest.TenFieldTest(new QuickUnion(10));

    }

}