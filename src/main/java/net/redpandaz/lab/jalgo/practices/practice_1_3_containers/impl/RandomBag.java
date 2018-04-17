package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.impl;

import net.redpandaz.lab.jalgo.api.Bag;
import net.redpandaz.lab.jalgo.impl.bags.LinkedListBag;

import java.util.Iterator;
import java.util.Random;

// 1.3.34
public class RandomBag<Item> implements Bag<Item> {
    private Bag<Item> bag = new LinkedListBag<>();

    @Override
    public void add(Item item) {
        bag.add(item);
    }

    @Override
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    @Override
    public int size() {
        return bag.size();
    }

    @Override
    public Iterator iterator() {
        Item[] tmp = (Item[]) new Object[bag.size()];
        int i = 0;
        for (Item item : bag) {
            tmp[i++] = item;
        }
        return new RandomIterator(tmp);
    }

    private class RandomIterator implements Iterator<Item> {
        private int cursor;
        private Item[] items;

        void shuffleArray(Item[] a) {
            int n = a.length;
            Random random = new Random();
            random.nextInt();
            for (int i = 0; i < n; i++) {
                int change = i + random.nextInt(n - i);
                swap(a, i, change);
            }
        }

        private void swap(Item[] a, int i, int change) {
            Item helper = a[i];
            a[i] = a[change];
            a[change] = helper;
        }

        RandomIterator(Item[] items) {

            this.items = items;
            shuffleArray(items);
        }

        @Override
        public boolean hasNext() {
            return items.length > cursor;
        }

        @Override
        public Item next() {
            Item item = items[cursor];
            cursor++;
            return item;
        }
    }
}
