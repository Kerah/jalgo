package net.redpandaz.lab.jalgo.practices.containers_1_3.impl;

import net.redpandaz.lab.jalgo.api.Deque;
import net.redpandaz.lab.jalgo.trifle.TrifleStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeuTest {

    @Test
    void isEmpty() {
        Deque<String> deque = new ArrayDequeu<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    void size() {
        Deque<String> deque = new ArrayDequeu<>();
        assertEquals(0, deque.size());
    }

    @Test
    void pushLeft() {
        Deque<String> deque = new ArrayDequeu<>();
        deque.pushLeft(TrifleStrings.String());
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    void pushRight() {
        Deque<String> deque = new ArrayDequeu<>();
        deque.pushRight(TrifleStrings.String());
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    void popLeft() {
        Deque<String> deque = new ArrayDequeu<>();
        String firstExpected = TrifleStrings.String();
        String secondExpected = TrifleStrings.String();

        deque.pushLeft(firstExpected);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
        assertEquals(firstExpected, deque.popLeft());

        deque.pushRight(firstExpected);
        assertEquals(1, deque.size());
        assertEquals(firstExpected, deque.popLeft());

        deque.pushLeft(firstExpected);
        deque.pushLeft(secondExpected);

        assertEquals(secondExpected, deque.popLeft());
        assertEquals(1, deque.size());
        assertEquals(firstExpected, deque.popLeft());

        deque.pushRight(firstExpected);
        deque.pushRight(secondExpected);
        assertEquals(firstExpected, deque.popLeft());
        assertEquals(secondExpected, deque.popLeft());

        deque.pushLeft(firstExpected);
        deque.pushRight(secondExpected);
        assertEquals(firstExpected, deque.popLeft());
        assertEquals(secondExpected, deque.popLeft());

        deque.pushRight(firstExpected);
        deque.pushLeft(secondExpected);
        assertEquals(secondExpected, deque.popLeft());
        assertEquals(firstExpected, deque.popLeft());
    }

    @Test
    void popRight() {
        Deque<String> deque = new ArrayDequeu<>();
        String firstExpected = TrifleStrings.String();
        String secondExpected = TrifleStrings.String();

        deque.pushLeft(firstExpected);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
        assertEquals(firstExpected, deque.popRight());

        deque.pushRight(firstExpected);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
        assertEquals(firstExpected, deque.popRight());

        deque.pushLeft(firstExpected);
        deque.pushLeft(secondExpected);
        assertEquals(firstExpected, deque.popRight());
        assertEquals(secondExpected, deque.popRight());


        deque.pushRight(firstExpected);
        deque.pushRight(secondExpected);
        assertEquals(secondExpected, deque.popRight());
        assertEquals(firstExpected, deque.popRight());

        deque.pushLeft(firstExpected);
        deque.pushRight(secondExpected);
        assertEquals(secondExpected, deque.popRight());
        assertEquals(firstExpected, deque.popRight());

        deque.pushRight(firstExpected);
        deque.pushLeft(secondExpected);
        assertEquals(firstExpected, deque.popRight());
        assertEquals(secondExpected, deque.popRight());
    }

}