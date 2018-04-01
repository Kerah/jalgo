package net.redpandaz.lab.jalgo.impl.commons;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LinkedNodeIteratorTest {
    @Test
    void shouldIteratorBeAble() {
        LinkedNode<String> node = new LinkedNode<>(UUID.randomUUID().toString());
        LinkedNodeIterator<String> it = new LinkedNodeIterator<>(node);
        int iterated = 0;
        while (it.hasNext()) {
            assertEquals(node.getItem(), it.next());
            iterated ++;
        }
        assertEquals(1, iterated);

    }
}