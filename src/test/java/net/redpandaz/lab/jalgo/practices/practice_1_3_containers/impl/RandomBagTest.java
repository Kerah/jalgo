package net.redpandaz.lab.jalgo.practices.practice_1_3_containers.impl;

import net.redpandaz.lab.jalgo.api.Bag;
import net.redpandaz.lab.jalgo.trifle.TrifleStrings;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomBagTest {

    @Test
    void add() {
        Bag<String> bag = new RandomBag<>();
        assertTrue(bag.isEmpty());
        bag.add(TrifleStrings.String());
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }

    @Test
    void isEmpty() {
        Bag<String> bag = new RandomBag<>();
        assertTrue(bag.isEmpty());
    }

    @Test
    void size() {
        Bag<String> bag = new RandomBag<>();
        assertEquals(0, bag.size());
    }

    @Test
    void iterator() {
        Bag<String> bag = new RandomBag<>();
        assertTrue(bag.isEmpty());
        String firstExpected = TrifleStrings.String();
        String secondExpected = TrifleStrings.String();
        bag.add(firstExpected);
        bag.add(secondExpected);

        assertFalse(bag.isEmpty());
        assertEquals(2, bag.size());

        Set<String> set = new HashSet<>();

        for (String item : bag) {
            set.add(item);
        }
        assertTrue(set.contains(firstExpected));
        assertTrue(set.contains(secondExpected));

        assertFalse(bag.isEmpty());
        assertEquals(2, bag.size());
    }
}