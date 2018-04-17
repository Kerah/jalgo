package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.orig;

import net.redpandaz.lab.jalgo.api.Queue;
import net.redpandaz.lab.jalgo.impl.queues.LinkedListQueue;

import java.util.ArrayList;
import java.util.List;
// practice 1.3.37
public class Josephus {
    private Queue<Integer> queue = new LinkedListQueue<>();

    Josephus(int length, int step) {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            items.add(i);
        }
        int j = -1;
        for (int i = 0; i < length; i++) {
            j = j+step;
            while (items.size() <= j) {
                j = j - items.size();
            }
            queue.enqueue(items.remove(j));
        }
    }
    public int[] steps() {
        int[] result  = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.dequeu();
        }
        return result;
    }
}
