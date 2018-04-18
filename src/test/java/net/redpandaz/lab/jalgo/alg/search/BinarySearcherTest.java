package net.redpandaz.lab.jalgo.alg.search;

import net.redpandaz.lab.jalgo.api.Array;
import net.redpandaz.lab.jalgo.api.Searcher;
import net.redpandaz.lab.jalgo.impl.commons.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearcherTest {

    @Test
    void search() {
        Array<Integer> data = new ResizableArray<>();
        data.add(1);
        data.add(2);
        data.add(3);

        Searcher<Integer> searcher = new BinarySearcher<Integer>(Integer::compareTo);

        assertEquals(0, searcher.Search(1, data));
        assertEquals(1, searcher.Search(2, data));
        assertEquals(2, searcher.Search(3, data));


    }
}