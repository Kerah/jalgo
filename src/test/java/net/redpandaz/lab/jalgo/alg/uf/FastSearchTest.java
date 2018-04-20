package net.redpandaz.lab.jalgo.alg.uf;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FastSearchTest extends UnionFindTest {
    @Test
    void checkCorrectCaseSuite() {
        TenFieldTest(new FastSearch(10));
    }


}