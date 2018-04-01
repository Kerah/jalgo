package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Bag;
import net.redpandaz.lab.jalgo.api.Stack;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {

    @Test
    void push() {
        String item = UUID.randomUUID().toString();
        Stack<String> bag = new FixedCapacityStack<String>(1);
        bag.push(item);
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
        assertEquals(item, bag.pop());
    }

    @Test
    void pop() {
        String firstItem = UUID.randomUUID().toString();
        String secondItem = UUID.randomUUID().toString();
        Stack<String> bag = new FixedCapacityStack<String>(2);
        bag.push(firstItem);
        bag.push(secondItem);
        assertFalse(bag.isEmpty());
        assertEquals(2, bag.size());
        assertEquals(secondItem, bag.pop());
        assertEquals(firstItem, bag.pop());
    }

    @Test
    void isEmpty() {
        Stack<String> bag = new FixedCapacityStack<String>(2);
        assertTrue(bag.isEmpty());
    }

    @Test
    void size() {
        Stack<String> bag = new FixedCapacityStack<String>(1);
        assertEquals(0, bag.size());
    }
}