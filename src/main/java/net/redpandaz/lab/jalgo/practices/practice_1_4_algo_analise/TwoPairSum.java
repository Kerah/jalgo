package net.redpandaz.lab.jalgo.practices.practice_1_4_algo_analise;

import net.redpandaz.lab.jalgo.impl.commons.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class TwoPairSum {
    @Nullable
    public static Pair<Integer> byValue(int[] items, int expected) {
        Arrays.sort(items);
        int j = items.length - 1;

        for (int i = 0; i < items.length; i++) {
            for (; j > i; j--) {
                int sum = items[i] + items[j];
                if (sum == expected) {
                    return new Pair<>(items[i], items[j]);
                }
                if (sum < expected) {
                    break;
                }
            }
        }
        return null;
    }
}
