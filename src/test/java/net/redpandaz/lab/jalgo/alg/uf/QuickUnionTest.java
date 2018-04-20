package net.redpandaz.lab.jalgo.alg.uf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionTest {
    @Test
    void checkTenScenario() {
        UnionFindTest.TenFieldTest(new QuickUnion(10));

    }

}