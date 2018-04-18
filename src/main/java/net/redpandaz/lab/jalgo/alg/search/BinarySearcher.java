package net.redpandaz.lab.jalgo.alg.search;

import net.redpandaz.lab.jalgo.api.Array;
import net.redpandaz.lab.jalgo.api.Searcher;

import java.util.Comparator;

public class BinarySearcher<Item> implements Searcher<Item> {
    private Comparator<Item> cmp;

    public BinarySearcher(Comparator<Item> cmp) {
        this.cmp = cmp;
    }

    @Override
    public int Search(Item value, Array<Item> items) {
        int lo = 0;
        int hi = items.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Item item = items.get(mid);
            int compared = cmp.compare(value, item);
            if (compared == 0) {
                return mid;
            } else if (compared < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
