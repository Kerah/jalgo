package net.redpandaz.lab.jalgo.impl.queues;

import net.redpandaz.lab.jalgo.api.Queue;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    @Test
    void enqueue() {
        String expected = UUID.randomUUID().toString();
        Queue<String> queue = new LinkedListQueue<String>();
        queue.enqueue(expected);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(expected, queue.dequeu());
    }

    @Test
    void dequeu() {
        String firstExpected = UUID.randomUUID().toString();
        String lastExpected = UUID.randomUUID().toString();

        Queue<String> queue = new LinkedListQueue<String>();
        queue.enqueue(firstExpected);
        queue.enqueue(lastExpected);

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals(firstExpected, queue.dequeu());
        assertEquals(lastExpected, queue.dequeu());


    }

    @Test
    void isEmpty() {
        Queue<String> queue = new LinkedListQueue<String>();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        Queue<String> queue = new LinkedListQueue<String>();
        assertEquals(0, queue.size());
    }
}