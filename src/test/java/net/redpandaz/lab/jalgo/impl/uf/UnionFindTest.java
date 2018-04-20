package net.redpandaz.lab.jalgo.impl.uf;

import net.redpandaz.lab.jalgo.api.UnionFind;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {
    static void TenFieldTest(UnionFind uf) {
        unconnected(uf,4, 3);
        unconnected(uf,3, 8);
        unconnected(uf,6, 5);
        unconnected(uf,9, 4);
        unconnected(uf,2, 1);
        connected(uf,8, 9);
        unconnected(uf,5, 0);
        unconnected(uf,7, 2);
        unconnected(uf,6, 1);
        connected(uf,1, 0);
        connected(uf,6, 7);
        unconnected(uf,7, 8);

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                connected(uf, i, j);
            }
        }
        assertEquals(1, uf.count());
    }

    static void connected(UnionFind uf, int p, int q) {
        assertTrue(uf.connected(p, q));

    }

    static void unconnected(UnionFind uf, int p, int q) {
        assertFalse(uf.connected(p, q));
        uf.union(p, q);
    }
}
