package net.redpandaz.lab.jalgo.impl.bags;

import net.redpandaz.lab.jalgo.api.Bag;
import net.redpandaz.lab.jalgo.trifle.TrifleStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBagTest {

    @Test
    void add() {
        Bag<String> bag = new LinkedListBag<>();
        assertTrue(bag.isEmpty());
        bag.add(TrifleStrings.String());
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }

    @Test
    void isEmpty() {
        Bag<String> bag = new LinkedListBag<>();
        assertTrue(bag.isEmpty());
    }

    @Test
    void size() {
        Bag<String> bag = new LinkedListBag<>();
        assertEquals(0, bag.size());
    }

    @Test
    void iterator() {
        Bag<String> bag = new LinkedListBag<>();
        assertTrue(bag.isEmpty());
        String expected = TrifleStrings.String();
        bag.add(expected);
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());

        for (String item : bag) {
            assertEquals(expected, item);
        }

        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }
}