package net.redpandaz.lab.jalgo.practices.practice_1_4_algo_analise;

import net.redpandaz.lab.jalgo.alg.search.BinarySearcher;
import net.redpandaz.lab.jalgo.api.Array;
import net.redpandaz.lab.jalgo.api.Searcher;
import net.redpandaz.lab.jalgo.impl.commons.ResizableArray;

import java.util.Arrays;

public class TwoSum {
    public static int withBruteForce(int[] a) {
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                    if (a[i] + a[j] == 0) {
                        cnt++;
                }
            }
        }
        return cnt;
    }
    public static int withBinarySearch(int []a) {
        int cnt = 0;
        int N = a.length;

        Arrays.sort(a);
        Array<Integer> array = new ResizableArray<>();

        for (int anA : a) {
            array.add(anA);
        }

        Searcher<Integer> searcher = new BinarySearcher<>(Integer::compareTo);
        for (int i=0; i < N; i ++) {
            if (searcher.Search(-a[i], array) > i)
                cnt++;

        }

        return cnt;
    }
}
