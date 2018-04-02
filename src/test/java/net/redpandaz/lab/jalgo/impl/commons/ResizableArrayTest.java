package net.redpandaz.lab.jalgo.impl.commons;

import net.redpandaz.lab.jalgo.api.Array;
import net.redpandaz.lab.jalgo.trifle.TrifleStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizableArrayTest {

    @Test
    void shouldReturnZeroSizeOnEmptyArray() {
        Array<String> items = new ResizableArray<>();
        assertEquals(0, items.size());
    }

    @Test
    void isEmpty() {
        Array<String> items = new ResizableArray<>();
        assertTrue(items.isEmpty());
    }

    @Test
    void add() {
        Array<String> items = new ResizableArray<>();
        items.add(TrifleStrings.String());
        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
        items.add(TrifleStrings.String());
        assertFalse(items.isEmpty());
        assertEquals(2, items.size());
        items.add(TrifleStrings.String());
        assertFalse(items.isEmpty());
        assertEquals(3, items.size());
        items.add(TrifleStrings.String());
        assertFalse(items.isEmpty());
        assertEquals(4, items.size());
    }

    @Test
    void delete() {
        String expectedFirst = TrifleStrings.String();
        String expectedSecond = TrifleStrings.String();
        Array<String> items = new ResizableArray<>();
        items.add(expectedFirst);
        items.add(expectedSecond);
        assertEquals(expectedFirst, items.delete(0));
        assertEquals(1, items.size());
        assertEquals(expectedSecond, items.get(0));
    }

    @Test
    void get() {
        String expectedFirst = TrifleStrings.String();
        String expectedSecond = TrifleStrings.String();
        Array<String> items = new ResizableArray<>();
        items.add(expectedFirst);
        items.add(expectedSecond);
        assertEquals(expectedFirst, items.get(0));
        assertEquals(expectedSecond, items.get(1));
    }

    @Test
    void pop() {
        String expectedFirst = TrifleStrings.String();
        String expectedSecond = TrifleStrings.String();
        Array<String> items = new ResizableArray<>();
        items.add(expectedFirst);
        items.add(expectedSecond);
        assertEquals(expectedSecond, items.pop());
        assertEquals(1, items.size());
        assertEquals(expectedFirst, items.pop());
        assertEquals(0, items.size());
        assertTrue(items.isEmpty());
    }

    @Test
    void iterator() {
        String[] expected = {TrifleStrings.String(), TrifleStrings.String()};
        Array<String> items = new ResizableArray<>();
        items.add(expected[0]);
        items.add(expected[1]);
        String[] results = {null, null};
        int i = 0;
        for (String item : items) {
            results[i++] = item;
        }

        for (i = 0; i < 2; i ++) {
            assertEquals(expected[i], results[i]);
        }
    }
}