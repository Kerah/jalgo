package net.redpandaz.lab.jalgo.impl.stacks;

import net.redpandaz.lab.jalgo.api.Stack;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayStackTest {
    @Test
    void push() {
        String item = UUID.randomUUID().toString();
        Stack<String> bag = new ResizingArrayStack<>();
        bag.push(item);
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
        assertEquals(item, bag.pop());
    }

    @Test
    void pop() {
        String firstItem = UUID.randomUUID().toString();
        String secondItem = UUID.randomUUID().toString();
        Stack<String> bag = new ResizingArrayStack<>();
        bag.push(firstItem);
        bag.push(secondItem);
        assertFalse(bag.isEmpty());
        assertEquals(2, bag.size());
        assertEquals(secondItem, bag.pop());
        assertEquals(firstItem, bag.pop());
    }

    @Test
    void isEmpty() {
        Stack<String> bag = new ResizingArrayStack<String>();
        assertTrue(bag.isEmpty());
    }

    @Test
    void size() {
        Stack<String> bag = new ResizingArrayStack<String>();
        assertEquals(0, bag.size());
    }

    @Test
    void iterator() {
        ResizingArrayStack<String> bag = new ResizingArrayStack<>();
        String expected = UUID.randomUUID().toString();
        for (String item : bag) {
            assertEquals(expected, item);
        }
    }

}