package net.redpandaz.lab.jalgo.impl.uf;

import org.junit.jupiter.api.Test;

class FastSearchTest extends UnionFindTest {
    @Test
    void checkCorrectCaseSuite() {
        TenFieldTest(new FastSearch(10));
    }


}